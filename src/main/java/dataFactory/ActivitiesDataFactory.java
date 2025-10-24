package dataFactory;

import dataObject.activities.CreateActivities;

public class ActivitiesDataFactory {

    public static CreateActivities getActivitiesData() {
        CreateActivities activitiesData = new CreateActivities();

        activitiesData.setId(2);
        return activitiesData;
    }
}
