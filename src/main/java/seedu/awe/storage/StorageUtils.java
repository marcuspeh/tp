package seedu.awe.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seedu.awe.commons.exceptions.IllegalValueException;
import seedu.awe.model.expense.Cost;
import seedu.awe.model.expense.IndividualAmount;
import seedu.awe.model.person.Person;

public class StorageUtils {

    /**
     * Convert a map of expenses between people and costs to a list of jsonAdaptedIndividualAmounts
     * @param expenseMap
     * @return
     */
    public static List<IndividualAmount> convertExpenseMapToListOfIndividualAmounts(Map<Person, Cost> expenseMap) {
        List<IndividualAmount> individualAmounts = new ArrayList<>();
        for (Person person : expenseMap.keySet()) {
            IndividualAmount individualAmount = new IndividualAmount(person,
                    expenseMap.get(person).getCost());
            individualAmounts.add(individualAmount);
        }
        return individualAmounts;
    }

    /**
     * Convert list of jsonAdaptedIndividualAmounts to a map of expenses between people and costs.
     * @param jsonAdaptedIndividualAmounts JsonAdaptedIndividualAmount object
     * @return Map of Persons to Costs.
     * @throws IllegalValueException
     */
    public static Map<Person, Cost> convertListOfJsonAdaptedIndividualAmountsToExpenseMap(
            List<JsonAdaptedIndividualAmount> jsonAdaptedIndividualAmounts) throws IllegalValueException {
        Map<Person, Cost> expenseMap = new HashMap<>();
        for (JsonAdaptedIndividualAmount jsonAdaptedIndividualAmount : jsonAdaptedIndividualAmounts) {
            IndividualAmount individualAmount = jsonAdaptedIndividualAmount.toModelType();
            Person person = individualAmount.getPerson();
            Cost cost = new Cost(individualAmount.getExpenditure());
            expenseMap.put(person, cost);
        }
        return expenseMap;
    }
}
