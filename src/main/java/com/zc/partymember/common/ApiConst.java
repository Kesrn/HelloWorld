package com.zc.partymember.common;

public interface ApiConst {
    String STATIC_JS = "/**/*.js";
    String STATIC_CSS = "/**/*.css";

    String ALL_1 = "/*";
    String ALL_2 = "/**";
    String ALL_3 = "/*.*";

    String API_LOGIN = "/login";
    String API_LOGOUT = "/logout";
    String API_HOME_CONSOLE = "/home";


    String API_USER = "/user";
    String API_USER_TEST = "/test";
    String API_USER_LIST = "/userlist";
    String API_USER_CREATE = "/create";
    String API_USER_UPDATE = "/{id}/update";
    String API_USER_DELETE = "/{id}/delete";
    String API_USER_PWD_CHANGE = "/{id}/changePassword";

    String API_QUESTION = "/question";
    String API_QUESTION_CREATE = "/create";
    String API_QUESTION_TEMPORARY = "/temporary";
    String API_QUESTION_DELETE = "/{id}/delete";
    String API_QUESTION_CHANGESTATUS = "/{id}/changeStatus";
    String API_QUESTION_CHANGETYPE = "/{id}/changeType";

    String API_QUESTIONNAIRE = "/partymember";
    String API_QUESTIONNAIRE_CREATE ="/create";
    String API_QUESTIONNAIRE_DELETE ="/{id}/delete";
    String API_QUESTIONNAIRE_CHANGEANSWER ="/{id}/changeAnswer";

    String API_DEPT = "/dept";
    String API_DEPT_CREATE = "/create";
    String API_DEPT_UPDATE = "/{id}/update";
    String API_DEPT_DELETE = "/{id}/delete";

    String API_QUESTION_JOINS = "/questionJoins";
    String API_QUESTION_JOINS_LIST = "/list";

    String API_MEMBER = "/member";
    String API_MEMBER_CREATE = "/create";
    String API_MEMBER_LIST = "/memberList";
    String API_MEMBER_UPDATE = "/{id}/update";
    String API_MEMBER_DELETE = "/{id}/delete";
}
