package com.ticketservice.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Event {

private long id;
private String title;
private String location;
private long startTimeStamp;
private long endTimeStamp;

}
