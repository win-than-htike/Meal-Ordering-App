package xyz.padc.mealordering.events;

import java.util.List;
import xyz.padc.mealordering.data.vos.Meal;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {
    public static class AttractionDataLoadedEvent {

        private String extraMessage;
        private List<Meal> mealList;

        public AttractionDataLoadedEvent(String extraMessage, List<Meal> mealList) {
            this.extraMessage = extraMessage;
            this.mealList = mealList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<Meal> getAttractionList() {
            return mealList;
        }
    }

}
