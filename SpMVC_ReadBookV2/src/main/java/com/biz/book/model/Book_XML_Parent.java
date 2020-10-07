package com.biz.book.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// 가장 바깥의 태그가 rss 이라는 것을 의미
@XmlRootElement(name="rss")
public class Book_XML_Parent {
	
	@XmlElement(name="channel")
	public Book_XML_Channel channel;
}
