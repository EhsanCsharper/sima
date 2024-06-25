package com.example.sima.exception;

import com.example.sima.utilities.Messages;

public enum SimaResponseCodes {
    INVALID_SIMA_REQUEST_IDENTIFIER("SIMA_001", "INVALID_SIMA_REQUEST_IDENTIFIER"),
    INVALID_SIMA_CUSTOMER_IDENTIFIER("SIMA_002", "INVALID_SIMA_CUSTOMER_IDENTIFIER"),
    ERROR_IN_CUSTOMER_SUBSYSTEM("SIMA_003", "ERROR_IN_CUSTOMER_SUBSYSTEM"),
    ERROR_IN_CONVERTING_PERSIAN_DATE_TO_XML_GREGORIAN_CALENDAR("SIMA_004", "ERROR_IN_CONVERTING_PERSIAN_DATE_TO_XML_GREGORIAN_CALENDAR"),
    INVALID_SIMA_CUSTOMER_INFO("SIMA_005", "INVALID_SIMA_CUSTOMER_INFO"),
    SIMA_CUSTOMER_ALREADY_EXIST("SIMA_006", "SIMA_CUSTOMER_ALREADY_EXIST"),
    INVALID_DATE_FORMAT("SIMA_007", "INVALID_DATE_FORMAT"),
    SIMA_SALE_SECURITIES_REQUEST_CAN_NOT_BE_NULL("SIMA_008", "SIMA_SALE_SECURITIES_REQUEST_CAN_NOT_BE_NULL"),
    SECURITIES_CODE_CAN_NOT_BE_EMPTY("SIMA_009", "SECURITIES_CODE_CAN_NOT_BE_EMPTY"),
    DESCRIPTION_CAN_NOT_BE_EMPTY("SIMA_010", "DESCRIPTION_CAN_NOT_BE_EMPTY"),
    IDENTIFIER_CAN_NOT_BE_EMPTY("SIMA_011", "IDENTIFIER_CAN_NOT_BE_EMPTY"),
    IBAN_CAN_NOT_BE_EMPTY("SIMA_012", "IBAN_CAN_NOT_BE_EMPTY"),
    SIMA_CUSTOMER_ID_CAN_NOT_BE_NULL("SIMA_013", "SIMA_CUSTOMER_ID_CAN_NOT_BE_NULL"),
    SIMA_CUSTOMER_INFO_CAN_NOT_BE_NULL("SIMA_014", "SIMA_CUSTOMER_INFO_CAN_NOT_BE_NULL"),
    INVALID_SIMA_REQUEST_STATUS("SIMA_015", "INVALID_SIMA_REQUEST_STATUS"),
    ERROR_IN_CREATE_SIMA_REQUEST("SIMA_016", "ERROR_IN_CREATE_SIMA_REQUEST"),
    ERROR_IN_CREATE_SIMA_REQUEST_BLOB_CONTAINER("SIMA_017", "ERROR_IN_CREATE_SIMA_REQUEST_BLOB_CONTAINER"),
    ERROR_IN_READ_SIMA_REQUEST_BLOB_CONTAINER("SIMA_018", "ERROR_IN_READ_SIMA_REQUEST_BLOB_CONTAINER"),
    ERROR_IN_SENDING_SIMA_REQUEST("SIMA_019", "ERROR_IN_SENDING_SIMA_REQUEST"),
    INVALID_SIMA_SECURITIES_IDENTIFIER("SIMA_020", "INVALID_SIMA_SECURITIES_IDENTIFIER"),
    ERROR_OCCURRED_IN_PARSING_SIMA_RESPONSE("SIMA_021", "ERROR_OCCURRED_IN_PARSING_SIMA_RESPONSE"),
    CAN_NOT_LOAD_SIMA_CONFIG_FILE("SIMA_022", "CAN_NOT_LOAD_SIMA_CONFIG_FILE"),
    ERROR_OCCURRED_IN_LOADING_BRANCH("SIMA_023", "ERROR_OCCURRED_IN_LOADING_BRANCH"),
    INVALID_SIMA_SECURITIES_TYPE_CODE("SIMA_024", "INVALID_SIMA_SECURITIES_TYPE_CODE"),
    INVALID_SIMA_CUSTOMER_CUSTOMER_NUMBER("SIMA_025", "INVALID_SIMA_CUSTOMER_CUSTOMER_NUMBER"),
    ERROR_IN_CREATE_EXCEL_REPORT("SIMA_026", "ERROR_IN_CREATE_EXCEL_REPORT"),
    ERROR_IN_LOAD_ALL_BANKS("SIMA_027", "ERROR_IN_LOAD_ALL_BANKS"),
    CAN_NOT_BE_USE_NEW_IBAN("SIMA_028", "CAN_NOT_BE_USE_NEW_IBAN"),
    ERROR_IN_LOAD_DEPOSIT("SIMA_029", "ERROR_IN_LOAD_DEPOSIT"),
    DEBTOR_CREDITOR_ITEM_COMMENT_CAN_NOT_BE_EMPTY("SIMA_030", "DEBTOR_CREDITOR_ITEM_COMMENT_CAN_NOT_BE_EMPTY"),
    ERROR_IN_LOAD_CURRENCY("SIMA_031", "ERROR_IN_LOAD_CURRENCY"),
    ERROR_IN_LOAD_COUNTRY("SIMA_032", "ERROR_IN_LOAD_COUNTRY"),
    CREDIT_OF_SELLING_START_DATE_HAS_EXPIRED("SIMA_033", "CREDIT_OF_SELLING_START_DATE_HAS_EXPIRED"),
    CREDIT_OF_SELLING_END_DATE_HAS_EXPIRED("SIMA_034", "CREDIT_OF_SELLING_END_DATE_HAS_EXPIRED"),
    SIMA_REQUEST_LOG_DOSE_NOT_EXIST("SIMA_035", "SIMA_REQUEST_LOG_DOSE_NOT_EXIST"),
    SIMA_SECURITIES_FEATURE_CAN_NOT_BE_EMPTY("SIMA_036", "SIMA_SECURITIES_FEATURE_CAN_NOT_BE_EMPTY"),
    SIMA_SELLING_START_DATE_CAN_NOT_BE_EMPTY("SIMA_037", "SIMA_SELLING_START_DATE_CAN_NOT_BE_EMPTY"),
    SIMA_SELLING_END_DATE_CAN_NOT_BE_EMPTY("SIMA_038", "SIMA_SELLING_END_DATE_CAN_NOT_BE_EMPTY"),
    ERROR_IN_LOAD_CUSTOMER("SIMA_039", "ERROR_IN_LOAD_CUSTOMER"),
    SIMA_SECURITIES_TYPE_CREDIT_DOSE_NOT_EXIST("SIMA_040", "SIMA_SECURITIES_TYPE_CREDIT_DOSE_NOT_EXIST"),
    SIMA_SECURITIES_TYPE_CREDIT_CAN_NOT_BE_EMPTY("SIMA_041", "SIMA_SECURITIES_TYPE_CREDIT_CAN_NOT_BE_EMPTY"),
    TOTAL_REQUESTED_CREDIT_CAN_NOT_BE_EMPTY("SIMA_042", "TOTAL_REQUESTED_CREDIT_CAN_NOT_BE_EMPTY"),
    BLANK_SIMA_SECURITIES_TYPE_CREDIT_DOSE_NOT_ENOUGH("SIMA_043", "BLANK_SIMA_SECURITIES_TYPE_CREDIT_DOSE_NOT_ENOUGH"),
    SIMA_CUSTOMER_CAN_NOT_BE_INCORPOREAL("SIMA_044", "SIMA_CUSTOMER_CAN_NOT_BE_INCORPOREAL"),
    SIMA_CUSTOMER_CAN_NOT_BE_UNDER_EIGHTEEN_YEARS_OLD("SIMA_045", "SIMA_CUSTOMER_CAN_NOT_BE_UNDER_EIGHTEEN_YEARS_OLD"),
    SIMA_CUSTOMER_CAN_NOT_BE_IN_BLACKLIST("SIMA_046", "SIMA_CUSTOMER_CAN_NOT_BE_IN_BLACKLIST"),
    SIMA_CUSTOMER_CAN_NOT_BE_IN_GRAYLIST("SIMA_047", "SIMA_CUSTOMER_CAN_NOT_BE_IN_GRAYLIST"),
    INVALID_SIMA_RESPONSE_STATUS("SIMA_048", "INVALID_SIMA_RESPONSE_STATUS"),
    ERROR_IN_EXTRACT_SIMA_SECURITIES_FEATURE("SIMA_049", "ERROR_IN_EXTRACT_SIMA_SECURITIES_FEATURE"),
    ERROR_IN_EXTRACT_SIMA_SECURITIES_COUPONS_DATE("SIMA_050", "ERROR_IN_EXTRACT_SIMA_SECURITIES_COUPONS_DATE"),
    ERROR_IN_UPDATE_JMS_STATUS_TO_PROCESSED("SIMA_050", "ERROR_IN_UPDATE_JMS_STATUS_TO_PROCESSED"),
    ERROR_IN_SAVE_SIMA_RESPONSE("SIMA_051", "ERROR_IN_SAVE_SIMA_RESPONSE"),
    INVALID_SIMA_REQUEST_TYPE("SIMA_052", "INVALID_SIMA_REQUEST_TYPE"),
    ERROR_IN_EXTRACT_SIMA_CONTRACT_FORM("SIMA_053", "ERROR_IN_EXTRACT_SIMA_CONTRACT_FORM"),
    SIMA_CUSTOMER_BIRTH_CERTIFICATE_ISSUE_DATE_CAN_NOT_BE_NULL("SIMA_054", "SIMA_CUSTOMER_BIRTH_CERTIFICATE_ISSUE_DATE_CAN_NOT_BE_NULL"),
    INVALID_SIMA_SECURITIES_STATUS("SIMA_055", "INVALID_SIMA_SECURITIES_STATUS"),
    ERROR_IN_LOAD_AVAILABLE_DEPOSIT_AMOUNT_FOR_WITHDRAW("SIMA_056", "ERROR_IN_LOAD_AVAILABLE_DEPOSIT_AMOUNT_FOR_WITHDRAW"),
    ERROR_IN_DEPOSIT_SUBSYSTEM("SIMA_057", "ERROR_IN_DEPOSIT_SUBSYSTEM"),
    SIMA_CUSTOMER_IS_NOT_REGISTERED("SIMA_058", "SIMA_CUSTOMER_IS_NOT_REGISTERED"),
    SALABLE_SECURITIES_COUNT_IS_LESS_THAN_THE_REQUESTED_COUNT("SIMA_059", "SALABLE_SECURITIES_COUNT_IS_LESS_THAN_THE_REQUESTED_COUNT"),
    CUSTOMER_CAN_NOT_WITHDRAW_FROM_THIS_DEPOSIT("SIMA_060", "CUSTOMER_CAN_NOT_WITHDRAW_FROM_THIS_DEPOSIT"),
    WITHDRAWABLE_AMOUNT_IS_LESS_THAN_THE_CONTRACT_AMOUNT("SIMA_061", "WITHDRAWABLE_AMOUNT_IS_LESS_THAN_THE_CONTRACT_AMOUNT"),
    ERROR_IN_BLOCK_DEPOSIT_AMOUNT("SIMA_062", "ERROR_IN_BLOCK_DEPOSIT_AMOUNT"),
    SIMA_CUSTOMER_STATUS_IS_NOT_REGISTERED_OR_UNSUCCESSFUL_REGISTERED("SIMA_63","SIMA_CUSTOMER_STATUS_IS_NOT_REGISTERED_OR_UNSUCCESSFUL_REGISTERED"),
    ERROR_IN_UNBLOCK_DEPOSIT_AMOUNT("SIMA_064", "ERROR_IN_UNBLOCK_DEPOSIT_AMOUNT"),
    ERROR_IN_ISSUE_DOCUMENT("SIMA_065", "ERROR_IN_ISSUE_DOCUMENT"),
    ERROR_CAN_NOT_DEFFER_SALE_SECURITIES_BRANCH_AND_REDEMPTION_SECURITIES_BRANCH("SIMA_066", "ERROR_CAN_NOT_DEFFER_SALE_SECURITIES_BRANCH_AND_REDEMPTION_SECURITIES_BRANCH"),
    ERROR_SIMA_TRANSFER_SECURITIES_REQUEST_COUNT_IS_MORE_THAN_REDEMPTION_SECURITIES_COUNT("SIMA_067", "ERROR_SIMA_TRANSFER_SECURITIES_REQUEST_COUNT_IS_MORE_THAN_REDEMPTION_SECURITIES_COUNT"),
    ERROR_IN_CHECKING_DEPOSIT_RIGHT("SIMA_068", "ERROR_IN_CHECKING_DEPOSIT_RIGHT"),
    DEPOSIT_CAN_NOT_DEPOSIT("SIMA_069", "DEPOSIT_CAN_NOT_DEPOSIT"),
    ERROR_IN_EXTRACT_SIMA_SECURITIES_CONTRACT_FORM("SIMA_070", "ERROR_IN_EXTRACT_SIMA_SECURITIES_CONTRACT_FORM"),
    ERROR_IN_CHANGING_TASK_ITEM_STATE("SIMA_071", "ERROR_IN_CHANGING_TASK_ITEM_STATE"),
    ERROR_REPEAT_OPERATION_OF_REPORT_AGAIN("SIMA_072", "ERROR_REPEAT_OPERATION_OF_REPORT_AGAIN"),
    ERROR_IN_CONVERTING_XML_GREGORIAN_CALENDAR_TO_PERSIAN_DATE("SIMA_073", "ERROR_IN_CONVERTING_XML_GREGORIAN_CALENDAR_TO_PERSIAN_DATE"),
    ERROR_IN_CREATE_NOTIFICATION("SIMA_074", "ERROR_IN_CREATE_NOTIFICATION"),
    ERROR_IN_SAVING_TASK_ITEM("SIMA_075","ERROR_IN_SAVING_TASK_ITEM"),
    COUNT_FOR_TRANSFER_IS_MORE_THAN_COUNT_OF_CONTRACT_SECURITIES("SIMA_076", "COUNT_FOR_TRANSFER_IS_MORE_THAN_COUNT_OF_CONTRACT_SECURITIES"),
    ERROR_SIMA_REDEMPTION_SECURITIES_REQUEST_COUNT_CAN_NOT_BE_ZERO("SIMA_077", "ERROR_SIMA_REDEMPTION_SECURITIES_REQUEST_COUNT_CAN_NOT_BE_ZERO"),
    ERROR_SIMA_BLOCK_ACCOUNT_AMOUNT_CAN_NOT_BE_ZERO("SIMA_078", "ERROR_SIMA_BLOCK_ACCOUNT_AMOUNT_CAN_NOT_BE_ZERO"),
    THE_NUMBER_OF_SELLER_AND_BUYER_CANNOT_BE_SAME("SIMA_079", "THE_NUMBER_OF_SELLER_AND_BUYER_CANNOT_BE_SAME"),
    ERROR_SIMA_BLOCK_ACCOUNT_AMOUNT_CAN_NOT_BE_MORE_TOTAL_AVAILABLE_AMOUNT("SIMA_080", "ERROR_SIMA_BLOCK_ACCOUNT_AMOUNT_CAN_NOT_BE_MORE_TOTAL_AVAILABLE_AMOUNT"),
    CUSTOMER_IS_NOT_OWNER_AND_SIGNER_OF_THE_DEPOSIT("SIMA_081", "CUSTOMER_IS_NOT_OWNER_AND_SIGNER_OF_THE_DEPOSIT"),
    MORE_THAN_ONE_REQUEST_FOUND("SIMA_082", "MORE_THAN_ONE_REQUEST_FOUND"),
    CUSTOMER_FIRST_NAME_IS_NULL_OR_EMPTY("SIMA_083", "CUSTOMER_FIRST_NAME_IS_NULL_OR_EMPTY"),
    CUSTOMER_LAST_NAME_IS_NULL_OR_EMPTY("SIMA_084", "CUSTOMER_LAST_NAME_IS_NULL_OR_EMPTY"),
    CUSTOMER_GENDER_IS_NULL_OR_EMPTY("SIMA_085", "CUSTOMER_GENDER_IS_NULL_OR_EMPTY"),
    CUSTOMER_FATHER_NAME_IS_NULL_OR_EMPTY("SIMA_086", "CUSTOMER_FATHER_NAME_IS_NULL_OR_EMPTY"),
    CUSTOMER_BIRTH_DATE_IS_NULL_OR_EMPTY("SIMA_087", "CUSTOMER_BIRTH_DATE_IS_NULL_OR_EMPTY"),
    CUSTOMER_BIRTH_PLACE_IS_NULL_OR_EMPTY("SIMA_088", "CUSTOMER_BIRTH_PLACE_IS_NULL_OR_EMPTY"),
    CUSTOMER_ID_NUMBER_IS_NULL_OR_EMPTY("SIMA_089", "CUSTOMER_ID_NUMBER_IS_NULL_OR_EMPTY"),
    CUSTOMER_ID_ISSUE_DATE_IS_NULL_OR_EMPTY("SIMA_090", "CUSTOMER_ID_ISSUE_DATE_IS_NULL_OR_EMPTY"),
    CUSTOMER_ID_ISSUE_PLACE_IS_NULL_OR_EMPTY("SIMA_091", "CUSTOMER_ID_ISSUE_PLACE_IS_NULL_OR_EMPTY"),
    CUSTOMER_NAME_IS_NULL_OR_EMPTY("SIMA_092", "CUSTOMER_NAME_IS_NULL_OR_EMPTY"),
    CUSTOMER_REGISTER_CODE_IS_NULL_OR_EMPTY("SIMA_093", "CUSTOMER_REGISTER_CODE_IS_NULL_OR_EMPTY"),
    CUSTOMER_REGISTER_DATE_IS_NULL_OR_EMPTY("SIMA_094", "CUSTOMER_REGISTER_DATE_IS_NULL_OR_EMPTY"),
    CUSTOMER_REGISTER_LOCATION_IS_NULL_OR_EMPTY("SIMA_095", "CUSTOMER_REGISTER_LOCATION_IS_NULL_OR_EMPTY"),
    CUSTOMER_NATIONAL_CODE_IS_NULL_OR_EMPTY("SIMA_096", "CUSTOMER_NATIONAL_CODE_IS_NULL_OR_EMPTY"),
    CUSTOMER_FIDA_IS_NULL_OR_EMPTY("SIMA_097", "CUSTOMER_FIDA_IS_NULL_OR_EMPTY"),
    CUSTOMER_NATIONAL_ID_IS_NULL_OR_EMPTY("SIMA_098", "CUSTOMER_NATIONAL_ID_IS_NULL_OR_EMPTY"),
    MORE_THAN_ONE_REPORT_FILE_FOUND("SIMA_099", "MORE_THAN_ONE_REPORT_FILE_FOUND"),
    ERROR_IN_READING_SIMA_REPORT_FILE("SIMA_100", "ERROR_IN_READING_SIMA_REPORT_FILE"),
    NO_REPORT_FILE_FOUND("SIMA_101", "NO_REPORT_FILE_FOUND"),
    ERROR_IN_GL_SUBSYSTEM("SIMA_102", "ERROR_IN_GL_SUBSYSTEM"),
    NO_TOPIC_FOUND("SIMA_103", "NO_TOPIC_FOUND"),
    INVALID_DEPOSIT_IBAN("SIMA_104", "INVALID_DEPOSIT_IBAN"),
    SIMA_CUSTOMER_IS_NOT_ALIVE("SIMA_105", "SIMA_CUSTOMER_IS_NOT_ALIVE"),
    DEPOSIT_AMOUNT_IS_LOW("SIMA_106", "DEPOSIT_AMOUNT_IS_LOW"),
    SIMA_ACCOUNT_IS_BLOCK("SIMA_107", "SIMA_ACCOUNT_IS_BLOCK"),
    SIMA_ACCOUNT_IS_PARTIAL_BLOCK("SIMA_108", "SIMA_ACCOUNT_IS_PARTIAL_BLOCK"),
    OLD_IBAN_AND_NEW_IBAN_CAN_NOT_BE_SAME("SIMA_109", "OLD_IBAN_AND_NEW_IBAN_CAN_NOT_BE_SAME"),
    DEPOSIT_IS_STAGNANT("SIMA_110", "DEPOSIT_IS_STAGNANT"),
    DEPOSIT_IS_NOT_ACTIVE("SIMA_111", "DEPOSIT_IS_NOT_ACTIVE"),
    ERROR_IN_GTR_SUBSYSTEM("SIMA_112", "ERROR_IN_GTR_SUBSYSTEM"),
    INVALID_TOPIC_TYPE("SIMA_113", "INVALID_TOPIC_TYPE"),
    INVALID_TOPIC("SIMA_114", "INVALID_TOPIC"),
    LIMITED_TOPIC("SIMA_115", "LIMITED_TOPIC"),
    BLOCKED_ACCOUNT_CAN_NOT_BE_TOTALLY_BLOCKED("SIMA_116", "BLOCKED_ACCOUNT_CAN_NOT_BE_TOTALLY_BLOCKED"),
    ONLY_BLOCKED_ACCOUNTS_CAN_BE_TOTALLY_UNBLOCKED("SIMA_117", "ONLY_BLOCKED_ACCOUNTS_CAN_BE_TOTALLY_UNBLOCKED"),
    BLOCKED_ACCOUNT_CAN_NOT_BE_PARTIALLY_BLOCKED("SIMA_118", "BLOCKED_ACCOUNT_CAN_NOT_BE_PARTIALLY_BLOCKED"),
    ERROR_SIMA_UNBLOCK_ACCOUNT_AMOUNT_CAN_NOT_BE_MORE_TOTAL_BLOCKED_AMOUNT("SIMA_119", "ERROR_SIMA_UNBLOCK_ACCOUNT_AMOUNT_CAN_NOT_BE_MORE_TOTAL_BLOCKED_AMOUNT"),
    TOPICS_INFO_CAN_NOT_BE_NULL_FOR_COMMON_SIMA_SECURITIES("SIMA_120", "TOPICS_INFO_CAN_NOT_BE_NULL_FOR_COMMON_SIMA_SECURITIES"),
    NOT_ONE_ACCOUNT_PER_BRANCH("SIMA_122", "NOT_ONE_ACCOUNT_PER_BRANCH"),
    OBJECT_CAN_NOT_CONVERT_TO_JSON_ERROR("SIMA_123", "OBJECT_CAN_NOT_CONVERT_TO_JSON_ERROR"),
    DEPOSIT_INFO_CAN_NOT_BE_NULL_FOR_SPECIAL_SIMA_SECURITIES("SIMA_124", "DEPOSIT_INFO_CAN_NOT_BE_NULL_FOR_SPECIAL_SIMA_SECURITIES"),
    RESALABLE_SECURITIES_COUNT_IS_LESS_THAN_THE_REQUESTED_COUNT("SIMA_125", "RESALABLE_SECURITIES_COUNT_IS_LESS_THAN_THE_REQUESTED_COUNT"),
    SIMA_CUSTOMER_CAN_NOT_BE_BLOCK("SIMA_126","SIMA_CUSTOMER_CAN_NOT_BE_BLOCK"),
    DEPOSIT_TYPE_CAN_NOT_BE_LONG_TERM("SIMA_127","DEPOSIT_TYPE_CAN_NOT_BE_LONG_TERM"),
    SIMA_RESPONSE_DOES_NOT_CONTAIN_ACCOUNT_INFORMATION("SIMA_128", "SIMA_RESPONSE_DOES_NOT_CONTAIN_ACCOUNT_INFORMATION"),
    SIMA_ACCOUNT_DOES_NOT_HAVE_COMPLETED_CONTRACT("SIMA_129","SIMA_ACCOUNT_DOES_NOT_HAVE_COMPLETED_CONTRACT"),
    CONTRACT_STATUS_IS_NOT_VALID("SIMA_130","CONTRACT_STATUS_IS_NOT_VALID"),
    INVALID_FILE_CONTENT("SIMA_131","INVALID_FILE_CONTENT"),
    ERROR_IN_ISSUE_DOCUMENT_AGAIN("SIMA_132","ERROR_IN_ISSUE_DOCUMENT_AGAIN"),
    ERROR_IN_ASSIGN_SIMA_SECURITIES_INTEREST_INFO("SIMA_133","ERROR_IN_ASSIGN_SIMA_SECURITIES_INTEREST_INFO"),
    ERROR_IN_LOAD_ASSIGNED_INTEREST_INFO("SIMA_134","ERROR_IN_LOAD_ASSIGNED_INTEREST_INFO"),
    DEPOSIT_OR_TOPICS_INFO_IS_EMPTY("SIMA_135","DEPOSIT_OR_TOPICS_INFO_IS_EMPTY"),
    INTEREST_AND_PRINCIPAL_IBAN_CAN_NOT_BE_EMPTY("SIMA_136","INTEREST_AND_PRINCIPAL_IBAN_CAN_NOT_BE_EMPTY"),
    IBAN_EXISTS_IN_SECURITIES("SIMA_137","IBAN_EXISTS_IN_SECURITIES"),
    BUYER_SIMA_ACCOUNT_IS_BLOCK("SIMA_138", "BUYER_SIMA_ACCOUNT_IS_BLOCK"),
    SELLER_SIMA_ACCOUNT_IS_BLOCK("SIMA_139", "SELLER_SIMA_ACCOUNT_IS_BLOCK"),
    BUYER_SIMA_ACCOUNT_IS_PARTIAL_BLOCK("SIMA_140", "BUYER_SIMA_ACCOUNT_IS_PARTIAL_BLOCK"),
    SELLER_SIMA_ACCOUNT_IS_PARTIAL_BLOCK("SIMA_141", "SELLER_SIMA_ACCOUNT_IS_PARTIAL_BLOCK"),
    BUYER_CUSTOMER_HAVE_CONTRACT_STATUS_SIMA_CONTRACT_REQUEST_SENT("SIMA_142","BUYER_CUSTOMER_HAVE_CONTRACT_STATUS_SIMA_CONTRACT_REQUEST_SENT"),
    CUSTOMER_HAVE_CONTRACT_STATUS_SIMA_CONTRACT_REQUEST_SENT("SIMA_143","CUSTOMER_HAVE_CONTRACT_STATUS_SIMA_CONTRACT_REQUEST_SENT"),
    BLOCKED_ACCOUNT_CAN_NOT_BE_PARTIALLY_UNBLOCKED("SIMA_144","BLOCKED_ACCOUNT_CAN_NOT_BE_PARTIALLY_UNBLOCKED"),
    SIMA_REPORT_FILE_NOT_FOUND("SIMA_145","SIMA_REPORT_FILE_NOT_FOUND"),
    USER_DOES_NOT_HAVE_PERMISSION("SIMA_146","USER_DOES_NOT_HAVE_PERMISSION"),
    //USER_UID_NOT_FOUND("SIMA_147","USER_UID_NOT_FOUND"),
    //ERROR_IN_CANCEL_BLOCK_ISSUE_DOCUMENT("SIMA_148", "ERROR_IN_CANCEL_BLOCK_ISSUE_DOCUMENT"),
    //NO_FILE_WAS_UPLOADED("SIMA_149", "NO_FILE_WAS_UPLOADED"),
    //ERROR_IN_SEND_REQUEST_TO_GTR("SIMA_150", "ERROR_IN_SEND_REQUEST_TO_GTR"),
    MESSAGE_HAS_BEEN_PROCESSED("SIMA_151", "MESSAGE_HAS_BEEN_PROCESSED"),
    //ERROR_IN_CLOSE_ACCOUNT("SIMA_152", "ERROR_IN_CLOSE_ACCOUNT"),
    //ERROR_IN_LOAD_GL_ACCOUNT("SIMA_153", "ERROR_IN_LOAD_GL_ACCOUNT"),
    //THERE_IS_NO_FAILED_DOCUMENT("SIMA_154", "THERE_IS_NO_FAILED_DOCUMENT"),
    //THERE_IS_MORE_THAN_ONE_FAILED_DOCUMENT("SIMA_155", "THERE_IS_MORE_THAN_ONE_FAILED_DOCUMENT"),
    //CUNCURENT_PROCESS("SIMA_156", "CUNCURENT_PROCESS"),
    //THE_CONTRACT_IS_NOT_ON_SENT_REQUEST_STATUS("SIMA_157", "THE_CONTRACT_IS_NOT_ON_SENT_REQUEST_STATUS"),
    //ERROR_IN_AFTER_PROCESS_RESPONSE("SIMA_158", "ERROR_IN_AFTER_PROCESS_RESPONSE"),
    //ERROR_IN_RESPONSE_PROCESS("SIMA_159", "ERROR_IN_RESPONSE_PROCESS"),
    //INVALID_SIMA_ACCOUNT_NUMBER("SIMA_160", "INVALID_SIMA_ACCOUNT_NUMBER"),
    //ERROR_IN_SAVE_FILE("SIMA_161", "ERROR_IN_SAVE_FILE"),
    SIMA_CONTRACT_DATE_IS_NOT_TODAY("SIMA_162", "SIMA_CONTRACT_DATE_IS_NOT_TODAY"),
    CATEGORY_ELEMENT_NOT_FOUND("SIMA_163", "CATEGORY_ELEMENT_NOT_FOUND"),
    SIMA_SUCCESS("SIMA_200", "SUCCESS"),
    SIMA_INVALID_EXCEPTION_TYPE("SIMA_998", "INVALID_EXCEPTION_TYPE"),
    SIMA_UNKNOWN_ERROR("SIMA_999", "UNKNOWN_ERROR");

    private final String code;
    private final String message;

    SimaResponseCodes(String code, String messageCode) {
        String message = Messages.getSimaMessage(messageCode);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
