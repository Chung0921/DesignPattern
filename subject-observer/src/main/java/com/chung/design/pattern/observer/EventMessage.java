package com.chung.design.pattern.observer;

/**
 * Created by Chung.
 * Usage: 通知的事件消息
 * Description:
 * Create dateTime: 18/9/27
 */
public class EventMessage {

	/**
	 * 事件id
	 */
	private Long id;

	/**
	 * 事件信息
	 */
	private String message;

	/**
	 * 发生事件的时间
	 */
	private Long timeStamp = System.currentTimeMillis();

	public EventMessage() {
	}

	public EventMessage( Long id, String message, Long timeStamp ) {
		this.id = id;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage( String message ) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp( Long timeStamp ) {
		this.timeStamp = timeStamp;
	}

	@Override
	public boolean equals( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass() != o.getClass() ) return false;

		EventMessage that = (EventMessage) o;

		if ( id != null ? !id.equals( that.id ) : that.id != null ) return false;
		if ( message != null ? !message.equals( that.message ) : that.message != null ) return false;
		return timeStamp != null ? timeStamp.equals( that.timeStamp ) : that.timeStamp == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "EventMessage{" +
				"id=" + id +
				", message='" + message + '\'' +
				", timeStamp=" + timeStamp +
				'}';
	}
}
