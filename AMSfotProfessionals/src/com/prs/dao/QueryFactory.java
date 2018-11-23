/**
 * 
 */
package com.prs.dao;

import com.prs.queries.UserQueries;
import com.prs.queries.AchievmentQueries;
import com.prs.queries.BookingQueries;
import com.prs.queries.ClientQueries;
import com.prs.queries.EducationQueries;
import com.prs.queries.ExperienceQueries;
import com.prs.queries.ImageQueries;
import com.prs.queries.MsgQueries;
import com.prs.queries.ProfessionalsQueries;
import com.prs.queries.RateQueries;
import com.prs.queries.SchedulerQueries;
import com.prs.queries.TrackerQueries;

/**
 * @author Isura
 * Query Factory
 */
public class QueryFactory {

	
	public static ClientQueries getClientQueries(){
		return new ClientQueries();
	}
	
	public static ProfessionalsQueries getProfessionalQueries(){
		return new ProfessionalsQueries();
	}

	public static UserQueries getUserQueries() {
		return new UserQueries();
	}
	
	public static MsgQueries getMsgQueries(){
		return new MsgQueries();
	}
	
	public static ExperienceQueries getExperienceQueries(){
		return new ExperienceQueries();
	}
	
	public static RateQueries getRateQueries(){
		return new RateQueries();
	}
	
	public static SchedulerQueries getSchedulerQueries(){
		return new SchedulerQueries();
	}
	
	public static TrackerQueries getTrackerQueries(){
		return new TrackerQueries();
	}

	public static BookingQueries getBookingQueries() {
		return new BookingQueries();
	}

	public static ImageQueries getImageQueries() {
		return new ImageQueries();
	}

	public static AchievmentQueries getAchievmentQueries() {
		return new AchievmentQueries();
	}

	public static EducationQueries getEducationQueries() {
		return new EducationQueries();
	}

}
