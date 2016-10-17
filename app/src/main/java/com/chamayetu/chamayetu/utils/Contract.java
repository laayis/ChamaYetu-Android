package com.chamayetu.chamayetu.utils;

import com.chamayetu.chamayetu.BuildConfig;
import com.chamayetu.chamayetu.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ChamaYetu
 * com.chamayetu.chamayetu.utils
 * Created by lusinabrian on 26/09/16.
 * Description: Constants class for the application
 * _SP_ files denote SharedPreferences
 */

public class Contract {
    public static final String TWITTER_KEY = BuildConfig.TWITTER_CONSUMER_KEY;
    public static final String TWITTER_CONSUMER_SECRET = BuildConfig.TWITTER_CONSUMER_KEY;
    public static final int REQUEST_INVITE = 1;

    /*TAGS*/
    public static final String LOGINACT_TAG = LoginActivity.class.getSimpleName();

    public static final String NOTIFICATION_SP_FILE = "Notifications";
    public static final String NOTIFICATION_SP_KEY="NotificationCount";
    public static final int SHAREPREF_PRIVATE_MODE = 0;

    public static final int RC_SIGN_IN = 9001;
    public static final String ANONYMOUS = "anonymous";

    //this is for the user node, to update the user's chamas
    public static final String CHAMA_GROUPS = "chamaGroups";

    public static final String CHAMA_NODE = "chamas";
    /**node in chama node to show the officials of the chama*/
    public static final String CHAMA_ROLES = "roles";
    public static final String CHAIR_PERSION = "chairperson";
    public static final String VICE_CHAIR = "viceChair";
    public static final String TREASURER = "treasurer";
    public static final String SECRETARY = "secretary";


    public static final String STATEMENT_NODE ="statements";
    public static final String MEMBERS_NODE = "members";
    public static final String USERS_NODE = "users";
    public static final String ACTIVITY_NODE = "activity";
    public static final String PROJECTS_NODE ="projects";

}
