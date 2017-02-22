package org.mounica.api.mappings;

import org.mounica.api.datatransfer.UserData;
import org.mounica.api.entity.User;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper; 

@Component
public class UserMapping extends ModelMapper {
	public UserData getDataFromEntity(User user){
		return map(user, UserData.class);
	}
	
	public User getEntityFromData(UserData userData){
		return map(userData, User.class);
	}
	
	public User getEntityFromData(UserData userData, boolean isNew){
		User user = getEntityFromData(userData);
		if(isNew){
			user.setId(new User().getId());
		}
		return user;
	}

}
