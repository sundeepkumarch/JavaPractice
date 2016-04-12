package com.mrsun;

/**
 *
 * @author sundechi
 */
public class UserName {

    public String newMember(String[] existingNames, String newName) {
        for(int i = 0; i < existingNames.length; i++){
            if(existingNames[i].equals(newName)){
                return newName;
            }else{
                
            }
        }
        return null;
    }
}
