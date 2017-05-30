package designpattern.Filter;

import designpattern.Filter.interfaces.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 30/05/17.
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
