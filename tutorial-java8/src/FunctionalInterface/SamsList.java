package FunctionalInterface;
import java.util.ArrayList;

import utils.Person;


public class SamsList extends ArrayList<Person> {
 
    public SamsList getSubList(final SamPredicate<Person> samPredicate) {
        final SamsList list = new SamsList();
 
        for (Person p : this) {
            if (samPredicate.test(p)) {
                list.add(p);
            }
        }
 
        return list;
    }
}