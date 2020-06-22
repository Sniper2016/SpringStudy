package cn.gameboys.aop.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerScheduler {
	public static final String EXCHANGE_DAY = "exchange_day";
	public static final String EXCHANGE_HOUR = "exchange_hour";
	public static final String EXCHANGE_MINITE = "exchange_minite";
	public static final String EXCHANGE_SECOND = "exchange_second";

	private static TimerScheduler instance = new TimerScheduler();
	private ScheduledExecutorService scheduler;
	private Map<String, List<Runnable>> listenMap;

	private TimerScheduler() {
		listenMap = new ConcurrentHashMap<String, List<Runnable>>();
		scheduler = Executors.newScheduledThreadPool(30);
		init();
	}

	public static TimerScheduler getInstance() {
		return instance;
	}

	private void init() {
		this.addLoopTask(new TimerTask() {
			Calendar cal = Calendar.getInstance();
			private int preDay = cal.get(Calendar.DAY_OF_MONTH);
			private int preHour = cal.get(Calendar.HOUR_OF_DAY);
			private int preMin = cal.get(Calendar.MINUTE);
			private int preSec = cal.get(Calendar.SECOND);

			@Override
			public void run() {
				cal.setTimeInMillis(System.currentTimeMillis());
				int nowDay = cal.get(Calendar.DAY_OF_MONTH);
				int nowHour = cal.get(Calendar.HOUR_OF_DAY);
				int nowMin = cal.get(Calendar.MINUTE);
				int nowSec = cal.get(Calendar.SECOND);

				if (nowSec != preSec) {
					preSec = nowSec;
					TimerScheduler.getInstance().dispatchEvent(TimerScheduler.EXCHANGE_SECOND);
				}

				if (nowMin != preMin) {
					preMin = nowMin;
					TimerScheduler.getInstance().dispatchEvent(TimerScheduler.EXCHANGE_MINITE);
				}

				if (nowHour != preHour) {
					preHour = nowHour;
					TimerScheduler.getInstance().dispatchEvent(TimerScheduler.EXCHANGE_HOUR);
				}

				if (nowDay != preDay) {
					preDay = nowDay;
					TimerScheduler.getInstance().dispatchEvent(TimerScheduler.EXCHANGE_DAY);
				}

				preSec = nowSec;
			}

		}, 1000, 1000);
	}

	/**
	 * 指定时分秒执行周期任务
	 * 
	 * @param task
	 * @param period
	 *            0非周期任务
	 * @param hourOfDay
	 * @param minuteOfDay
	 * @param secondOfMinute
	 */
	public void addTask(TimerTask task, long period, TimeUnit periodUnit, int hourOfDay, int minuteOfDay, int secondOfMinute) {
		Calendar cal = Calendar.getInstance();
		long nowMillis = cal.getTimeInMillis();

		cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
		cal.set(Calendar.MINUTE, minuteOfDay);
		cal.set(Calendar.SECOND, secondOfMinute);
		long taskMillis = cal.getTimeInMillis();
		if (taskMillis - nowMillis < 0) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
			taskMillis = cal.getTimeInMillis();
		}
		long delay = 0L;

		if (nowMillis <= taskMillis) {
			delay = taskMillis - nowMillis;
		} else {
			long delayAdd = 0;
			switch (periodUnit) {
			case MILLISECONDS:
				delayAdd = period;
				break;
			case SECONDS:
				delayAdd = period * 1000;
				break;
			case MINUTES:
				delayAdd = period * 60 * 1000;
				break;
			case HOURS:
				delayAdd = period * 60 * 60 * 1000;
				break;
			default:
			case DAYS:
				delayAdd = period * 24 * 60 * 60 * 1000;
				break;
			}
			delay = nowMillis - taskMillis + delayAdd;
		}

		if (period > 0) {
			this.scheduler.scheduleAtFixedRate(task, delay, period, TimeUnit.MILLISECONDS);
		} else {
			this.scheduler.schedule(task, delay, TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * 间隔多少时间后处理
	 * 
	 * @param task
	 * @param delay
	 */
	public void doLater(Runnable task, long delay) {
		this.scheduler.schedule(task, delay, TimeUnit.MILLISECONDS);
	}

	public void addLoopTask(TimerTask task, int delay, int period) {
		this.scheduler.scheduleAtFixedRate(task, delay, period, TimeUnit.MILLISECONDS);
	}

	public void addLoopTask(Runnable task, int delay, int period) {
		this.scheduler.scheduleAtFixedRate(task, delay, period, TimeUnit.MILLISECONDS);
	}

	public boolean addEventListener(String event, Runnable listener) {
		List<Runnable> listenerList = listenMap.get(event);
		if (listenerList == null) {
			listenerList = new ArrayList<Runnable>();
			listenMap.put(event, listenerList);
		}
		if (!listenerList.contains(listener))
			listenerList.add(listener);
		return true;
	}

	public boolean removeEventListener(String event, Runnable listener) {
		List<Runnable> listenerList = listenMap.get(event);
		if (listenerList != null)
			listenerList.remove(listener);
		return true;
	}

	public void dispatchEvent(String event) {
		List<Runnable> listenerList = listenMap.get(event);
		if (listenerList != null) {
			for (Runnable run : listenerList) {
				try {
					run.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TimerScheduler.getInstance().addTask(new TimerTask() {
		// @Override
		// public void run() {
		// System.out.println("hello");
		// }
		// }, 3000, TimeUnit.MILLISECONDS, 0, 3, 0);
		// TimerScheduler.getInstance().addLoopTask(new TimerTask(){
		//
		// @Override
		// public void run() {
		// System.out.println("hello , test");
		// }}, 3000, 3000);

		// TimerScheduler.getInstance().addEventListener(TimerScheduler.EXCHANGE_SECOND,
		// new TimerTask(){
		//
		// @Override
		// public void run() {
		// System.out.println("past 1sec>");
		//
		// }});
		// TimerScheduler.getInstance().addEventListener(TimerScheduler.EXCHANGE_MINITE,
		// new TimerTask(){
		//
		// @Override
		// public void run() {
		// System.out.println("past 1fen------------------------------");
		//
		// }});
		System.out.println("start");
		TimerScheduler.getInstance().doLater(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hello, baby");
			}

		}, 3000);
	}
}
