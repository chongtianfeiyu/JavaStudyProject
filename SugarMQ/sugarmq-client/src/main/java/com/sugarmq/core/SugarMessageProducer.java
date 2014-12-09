/**
 * 
 */
package com.sugarmq.core;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

/**
 * 抽象的消息生产者
 * 
 * @author manzhizhen
 * 
 */
public abstract class SugarMessageProducer implements MessageProducer {
	protected volatile AtomicInteger deliveryMode = new AtomicInteger(Message.DEFAULT_DELIVERY_MODE); // 持久性和非持久性
	protected volatile AtomicLong timeToLive = new AtomicLong(Message.DEFAULT_TIME_TO_LIVE); // 消息有效期
	protected volatile AtomicInteger priority = new AtomicInteger(Message.DEFAULT_PRIORITY);	// 消息优先级

	protected volatile AtomicBoolean disableMessageId = new AtomicBoolean(false);
	
	@Override
	public int getDeliveryMode() throws JMSException {
		return deliveryMode.get();
	}

	@Override
	public int getPriority() throws JMSException {
		return priority.get();
	}

	@Override
	public long getTimeToLive() throws JMSException {
		return timeToLive.get();
	}

	@Override
	public void send(Message arg0) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void send(Destination arg0, Message arg1) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void send(Message arg0, int arg1, int arg2, long arg3)
			throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void send(Destination arg0, Message arg1, int arg2, int arg3,
			long arg4) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void setDeliveryMode(int deliveryMode) throws JMSException {
		this.deliveryMode.set(deliveryMode);
	}
	
	@Override
	public void setPriority(int priority) throws JMSException {
		this.priority.set(priority);
	}

	@Override
	public void setTimeToLive(long timeToLive) throws JMSException {
		this.timeToLive.set(timeToLive);
	}


}