package org.calling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnyPhone {

    //RatePolicy switchable to subclasses, NO final
    private RatePolicy ratePolicy;
    private List<PhoneCall> calls = new ArrayList<>();

    public AnyPhone(RatePolicy ratePolicy){
        this.ratePolicy = ratePolicy;
    }

    /*
     * unmodifiableList() ?
     */
    public List<PhoneCall> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    /*
     * message to Policy
     */
    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
