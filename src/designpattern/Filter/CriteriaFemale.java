package designpattern.Filter;

import designpattern.Filter.interfaces.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 30/05/17.
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}