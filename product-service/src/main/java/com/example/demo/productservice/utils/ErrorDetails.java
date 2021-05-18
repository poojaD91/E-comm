package com.example.demo.productservice.utils;

import java.time.LocalDateTime;

public class ErrorDetails {

	 	private LocalDateTime date;
	 	private String msg;
	 	private String Description;
	 	
		public ErrorDetails() {}

		public ErrorDetails(LocalDateTime date, String msg, String description) {
			super();
			this.date = date;
			this.msg = msg;
			Description = description;
		}

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}
		
	 	
}
