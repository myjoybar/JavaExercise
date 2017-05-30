package designpattern.Filter.interfaces;

import designpattern.Filter.Person;

import java.util.List;

/**
 * Created by joybar on 30/05/17.
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
