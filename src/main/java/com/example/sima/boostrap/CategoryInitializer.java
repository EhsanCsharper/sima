package com.example.sima.boostrap;

import com.example.sima.SimaCodes;
import com.example.sima.domain.Category;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.repository.CategoryRepository;
import com.example.sima.repository.ConstantCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(CategoryInitializer.class);
    private final CategoryRepository categoryRepository;
    private final ConstantCategoryRepository constantCategoryRepository;

    @Value("${sima.initialize.category}")
    private boolean shouldInit;

    public CategoryInitializer(CategoryRepository categoryRepository, ConstantCategoryRepository constantCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.constantCategoryRepository = constantCategoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        if (!shouldInit)
            return;

        // ==============================================================================================
        // CATEGORY
        // ==============================================================================================
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(SimaCodes.SIMA_REQUEST_STATUS));
        categories.add(new Category(SimaCodes.SIMA_SECURITIES_STATUS));
        categories.add(new Category(SimaCodes.SIMA_RESPONSE_ACK_TYPE));
        categories.add(new Category(SimaCodes.SIMA_REGISTER_LOG_OPERATION));
        categories.add(new Category(SimaCodes.SIMA_REQUEST_TYPES));
        categories.add(new Category(SimaCodes.SIMA_CUSTOMER_IDENTIFIER_TYPE));
        categories.add(new Category(SimaCodes.SIMA_CUSTOMER_STATUS));
        categories.add(new Category(SimaCodes.SIMA_SECURITIES_FEATURE));
        categories.add(new Category(SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        categories.add(new Category(SimaCodes.SIMA_RESPONSE_ERROR_TYPES));
        categories.add(new Category(SimaCodes.SIMA_CONTRACT_STATUS));
        categories.add(new Category(SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        categories.add(new Category(SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        categories.add(new Category(SimaCodes.SIMA_CONTRACT_ACTION_TYPE));
        categories.add(new Category(SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        categories.add(new Category(SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        categories.add(new Category(SimaCodes.SIMA_ACCOUNT_OPERATION_TYPE));
        categories.add(new Category(SimaCodes.SIMA_CUSTOMER_CHANGED_FIELD));
        categories.add(new Category(SimaCodes.SIMA_INTEREST_PAYMENT_INTERVAL_UNIT));
        categories.add(new Category(SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        categories.add(new Category(SimaCodes.SIMA_ACCOUNT_CHANGED_FIELD));
        categories.add(new Category(SimaCodes.SIMA_CUSTOMER_OPERATION_TYPE));
        categories.add(new Category(SimaCodes.SIMA_BLOCK_OR_UNBLOCK_ACCOUNT_TYPES));
        categories.add(new Category(SimaCodes.SIMA_IBAN_TYPE));
        categories.add(new Category(SimaCodes.SIMA_TRADING_SOURCE_TYPE));
        categories.add(new Category(SimaCodes.SIMA_DEPOSIT_INTEREST_STATUS));
        categories.add(new Category(SimaCodes.SIMA_MACRO_OPERATION_TYPE));
        categories.add(new Category(SimaCodes.DAILY_REPORT_MACRO_STATUS));
        categories.add(new Category(SimaCodes.SIMA_REPORT_FILE_TYPE));
        categories.add(new Category(SimaCodes.FILE_RESULT_TYPE));
        categories.add(new Category(SimaCodes.MQ_REQUEST_STATUS));

        categories.stream().forEach(c -> {
            Optional<Category> categoryOptional = categoryRepository.findByName(c.getName());
            if (categoryOptional.isEmpty()) {
                categoryRepository.save(c);
            }
        });

        // ==============================================================================================
        // CONSTANT CATEGORY ELEMENT
        // ==============================================================================================

        List<MainConstCategoryElement> constCategoryElements = new ArrayList<>();
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REQUEST_SENT_STATUS, "ارسال شده", SimaCodes.SIMA_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REQUEST_WAIT_FOR_SEND_STATUS, "در انتظار ارسال", SimaCodes.SIMA_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REQUEST_REGISTERED_STATUS, "ثبت شده", SimaCodes.SIMA_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REQUEST_HAS_RESPONSE_STATUS, "دارای پاسخ", SimaCodes.SIMA_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REQUEST_ERROR_ON_SEND_STATUS, "خطا در زمان ارسال", SimaCodes.SIMA_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_ACTIVE_STATUS, "فعال", SimaCodes.SIMA_SECURITIES_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_INACTIVE_STATUS, "غیر فعال", SimaCodes.SIMA_SECURITIES_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_MATURED_STATUS, "منقضی شده", SimaCodes.SIMA_SECURITIES_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESPONSE_SUCCESS_ACK, "موفق", SimaCodes.SIMA_RESPONSE_ACK_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESPONSE_WARNING_ACK, "هشدار", SimaCodes.SIMA_RESPONSE_ACK_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESPONSE_FAILURE_ACK, "نا موفق", SimaCodes.SIMA_RESPONSE_ACK_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RECEIVE_RESPONSE_OPERATION, "دریافت پاسخ از صف", SimaCodes.SIMA_REGISTER_LOG_OPERATION));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SEND_REQUEST_OPERATION, "ارسال پاسخ به صف", SimaCodes.SIMA_REGISTER_LOG_OPERATION));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PROCESS_RESPONSE_OPERATION, "بررسی پاسخ دریافت شده از صف", SimaCodes.SIMA_REGISTER_LOG_OPERATION));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PROCESS_AND_PARS_JMS_REQUEST_OPERATION, "بررسی jms پاسخ دریافت شده از صف", SimaCodes.SIMA_REGISTER_LOG_OPERATION));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ISSUE_DOCUMENT_OPERATION, "بررسی صدور سند", SimaCodes.SIMA_REGISTER_LOG_OPERATION));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SALE_SECURITIES_REQUEST_TYPE, "درخواست فروش اوراق بهادار", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UPDATE_CUSTOMER_IBAN_REQUEST_TYPE, "درخواست بروز رسانی شماره شبا مشتری", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESALE_SECURITIES_REQUEST_TYPE, "درخواست بازفروش اوراق بهادار", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_SECURITIES_REQUEST_TYPE, "درخواست بازخرید اوراق بهادار", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TRANSFER_SECURITIES_REQUEST_TYPE, "درخواست انتقال اوراق بهادار", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ALLOCATED_SECURITIES_CODES_REQUEST_TYPE, "درخواست دریافت کد کلیه اوراق تخصیص داده شده", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_CODE_FOR_SAlE_REQUEST_TYPE, "درخواست دریافت کد اوراق قابل فروش", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_CODE_FOR_RESAlE_REQUEST_TYPE, "درخواست دریافت کد اوراق قابل بازفروش", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_CODE_FOR_REDEMPTION_REQUEST_TYPE, "درخواست دریافت کد اوراق قابل بازخرید", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_CODE_FOR_TRANSFER_REQUEST_TYPE, "درخواست دریافت کد اوراق قابل انتقال", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ALLOCATED_SECURITIES_REQUEST_TYPE, "درخواست دریافت اطلاعات نوع اوراق تخصیص یافته", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_FOR_SALE_REQUEST_TYPE, "دریافت نوع اوراق قابل فروش", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_FOR_RESALE_REQUEST_TYPE, "دریافت نوع اوراق قابل بازفروش", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_FOR_TRANSFER_REQUEST_TYPE, "دریافت نوع اوراق قابل انتقال", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_FOR_REDEMPTION_REQUEST_TYPE, "دریافت نوع اوراق قابل بازخرید", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SALE_INTEREST_FOR_ONE_SECURITIES_REQUEST_TYPE, "دریافت سود اوراق به ازای یک برگ", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_INTEREST_REQUEST_TYPE, "دریافت اطلاعات سود و جریمه بازخرید", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESALE_INTEREST_FOR_ONE_SECURITIES_REQUEST_TYPE, "دریافت سود بازفروش به ازای یک برگ", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_BLOCK_CUSTOMER_REQUEST_TYPE, "انسداد مشتری", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UNBLOCK_CUSTOMER_REQUEST_TYPE, "رفع انسداد مشتری", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_IS_PARTY_BLOCKED_REQUEST_TYPE, "بررسی وضعیت مسدودی مشتری", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CREATE_PERSON_REQUEST_TYPE, "ایجاد مشتری حقیقی", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CREATE_ORGANIZATION_REQUEST_TYPE, "ایجاد مشتری حقوقی", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UPDATE_PERSON_REQUEST_TYPE, "به روز رسانی مشتری حقیقی", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UPDATE_ORGANIZATION_REQUEST_TYPE, "به روز رسانی مشتری حقوقی", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_GET_PERSON_REQUEST_TYPE, "دریافت اطلاعات مشتری حقیقی", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_GET_ORGANIZATION_REQUEST_TYPE, "دریافت اطلاعات مشتری حقوقی", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_GET_SIMA_SECURITIES_COUPONS_DATE_REQUEST_TYPE, "دریافت لیست کوپن های (تاریخ) واریز سود", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PARTIAL_BLOCK_ACCOUNT_REQUEST_TYPE, "انسداد بخشی حساب", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_BLOCK_ACCOUNT_REQUEST_TYPE, "انسداد کل حساب", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UNBLOCK_ACCOUNT_REQUEST_TYPE, "رفع انسداد کل حساب", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PARTIAL_UNBLOCK_ACCOUNT_REQUEST_TYPE, "رفع انسداد بخشی حساب", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_GET_ACCOUNT_REQUEST_TYPE, "دریافت اطلاعات حساب سیما", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PING_REQUEST_TYPE, "بررسی اتصال به سامانه سیما", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REVERSE_CONTRACT_REQUEST_TYPE, "لغو قرارداد", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UPDATE_AGENT_IBAN_REQUEST_TYPE, "به روز رسانی شبای اوراق", SimaCodes.SIMA_REQUEST_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_NATIONAL_CODE_TYPE, "شناسه ملی", SimaCodes.SIMA_CUSTOMER_IDENTIFIER_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_IDENTIFIER_CODE_TYPE, "کد ملی", SimaCodes.SIMA_CUSTOMER_IDENTIFIER_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_FOREIGN_CUSTOMER_NATIONAL_CODE_TYPE, "کد اتباع", SimaCodes.SIMA_CUSTOMER_IDENTIFIER_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_BLOCK_STATUS, "مسدود", SimaCodes.SIMA_CUSTOMER_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_ACTIVE_STATUS, "فعال", SimaCodes.SIMA_CUSTOMER_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_WAITING_FOR_RESPONSE_STATUS, "در انتظار پاسخ", SimaCodes.SIMA_CUSTOMER_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_UNSUCCESSFUL_REGISTERED_STATUS, "ثبت ناموفق", SimaCodes.SIMA_CUSTOMER_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SELLING_START_DATE, "روز آغاز فروش", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SELLING_END_DATE, "روز پایان فروش", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_DURATION, "مدت اوراق", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_INTEREST_PAYMENT_INTERVAL, "مقاطع پرداخت سود", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_COUPON_RATE, "نرخ سود علی الحساب", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_RATE, "نرخ سود بازخرید", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PAR_VALUE, "ارزش اسمی هر برگ اوراق", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_NON_REDEEMABLE, "قابلیت بازخرید", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_NON_TRANSFERABLE, "غیرقابل انتقال", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_FINAL_RATE_OF_RETURN, "نرخ سود قطعی", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_BOND_TYPE, "نوع اوراق", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ISSUE_SUBJECT, "موضوع انتشار", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_GUARANTOR, "نام تضمین کننده", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TRUSTEE, "نام امین", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_OBLIGOR, "نام بانی", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ISSUER, "نام ناشر", SimaCodes.SIMA_SECURITIES_FEATURE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ACTIVE_SECURITIES_ACCOUNT, "فعال", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_BLOCKED_SECURITIES_ACCOUNT, "مسدود کل", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PARTIAL_BLOCKED_SECURITIES_ACCOUNT, "مسدود بخشی", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_MATURED_SECURITIES_ACCOUNT, "سررسید شده", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CLOSED_SECURITIES_ACCOUNT, "تسویه شده (ابطال شده)", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_WAIT_FOR_BLOCK_RESPONSE_ACCOUNT, "در انتظار دریافت پاسخ انسداد", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_WAIT_FOR_UNBLOCK_RESPONSE_ACCOUNT, "در انتظار دریافت پاسخ رفع انسداد", SimaCodes.SIMA_SECURITIES_ACCOUNT_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_REGISTERED, "ثبت شده", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_REQUEST_SENT, "درخواست به سامانه سیما ارسال شده", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_FAILED_REQUEST, "خطا در ارسال درخواست", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_COMPLETED, "منعقد شده", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_DID_NOT_COMPLETED, "منعقد نشده", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_TERMINATED, "خاتمه یافته", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_CANCELED, "لغو شده", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_FAILED_ISSUE_DOCUMENT, "خطا در صدور سند", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_CANCELED_FAILED_ISSUE_DOCUMENT, "خطا در صدور سند لغو قرارداد", SimaCodes.SIMA_CONTRACT_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_COUPONS_DATE_CHANGED_FIELD, "فیلد تاریخ کوپن ها", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_SALABLE_CHANGED_FIELD, "فیلد قابل فروش", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_REDEEMABLE_CHANGED_FIELD, "فیلد قابل بازخرید", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RESALABLE_BY_AGENT_CHANGED_FIELD, "فیلد قابل بازفروش عامل", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RESALABLE_BY_PUBLISHER_CHANGED_FIELD, "فیلد قابل بازفروش ناشر", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RESALE_AVAILABLE_BALANCE_BY_AGENT_CHANGED_FIELD, "فیلد مانده بازفروش عامل", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RESALE_AVAILABLE_BALANCE_BY_PUBLISHER_CHANGED_FIELD, "فیلد مانده بازفروش ناشر", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_TRANSFERABLE_CHANGED_FIELD, "فیلد قابل انتقال", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_PRINCIPAL_IBAN_CHANGED_FIELD, "فیلد شبای اصل", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_INTEREST_IBAN_CHANGED_FIELD, "فیلد شبای سود", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_INTEREST_AMOUNT_CHANGED_FIELD, "فیلد سود فروش اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_DAILY_INTEREST_AMOUNT_CHANGED_FIELD, "فیلد سود روزانه فروش اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_IS_SPECIAL_CHANGED_FIELD, "فیلد عام/خاص اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_DEPOSIT_ID_CHANGED_FIELD, "فیلد سپرده اوراق خاص اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_CREDITOR_TOPIC_CHANGED_FIELD, "فیلد سرفصل بستانکار اوراق عام اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_DEBTOR_TOPIC_CHANGED_FIELD, "فیلد سرفصل بدهکار اوراق عام اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_SALE_AVAILABLE_BALANCE_CHANGED_FIELD, "فیلد تعداد قابل فروش اوراق", SimaCodes.SIMA_SECURITIES_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RECEIVED_RESPONSE_OPERATION_TYPE, "پاسخ سیما دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_ALLOCATED_SIMA_SECURITIES_RESPONSE_OPERATION_TYPE, "دریافت پاسخ کدهای اوراق تخصیص یافته و ایجاد اوراق ", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.FILL_ALLOCATED_SIMA_SECURITIES_RESPONSE_OPERATION_TYPE, "پاسخ پر کردن اطلاعات اوراق تخصیص شده", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_ALLOCATED_SIMA_SECURITIES_STATUS_RESPONSE_OPERATION_TYPE, "به روز رسانی آخرین پاسخ اوراق تخصیص شده", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_ALLOCATED_SIMA_SECURITIES_DAILY_INTEREST_AMOUNT_RESPONSE_OPERATION_TYPE, "به روز رسانی سود روزانه اوراق تخصیص شده", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_SECURITIES_INTEREST_INFO_OPERATION_TYPE, "به روز رسانی اطلاعات سرفصل ها یا سپرده مبدا و مقصد اصل و سود", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_SECURITIES_LAST_RESPONSE_OPERATION_TYPE, "دریافت پاسخ", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_CUSTOMER_LAST_RESPONSE_OPERATION_TYPE, "به روز رسانی آخرین پاسخ مشتری سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_CONTRACT_LAST_RESPONSE_OPERATION_TYPE, "دریافت پاسخ", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_ACCOUNT_LAST_RESPONSE_OPERATION_TYPE, "دریافت پاسخ", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SALES_SECURITIES_CODES_RESPONSE_OPERATION_TYPE, "پاسخ اوراق قابل فروش دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_SECURITIES_CODES_RESPONSE_OPERATION_TYPE, "پاسخ اوراق قابل بازخرید دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESALE_SECURITIES_CODES_RESPONSE_OPERATION_TYPE, "پاسخ اوراق قابل بازفروش دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TRANSFER_SECURITIES_CODES_RESPONSE_OPERATION_TYPE, "پاسخ اوراق قابل انتقال دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RECEIVED_COUPONS_DATE_OPERATION_TYPE, "پاسخ کوپن های اوراق دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_CUSTOMER_RESPONSE_OPERATION_TYPE, "دریافت پاسخ", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_CUSTOMER_STATUS_RESPONSE_OPERATION_TYPE, "عملیات به روز رسانی وضعیت مشتری سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_BLOCK_CUSTOMER_OPERATION_TYPE, "مسدود کردن مشتری سیما", SimaCodes.SIMA_CUSTOMER_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_UNBLOCK_CUSTOMER_OPERATION_TYPE, "رفع مسدودی مشتری سیما", SimaCodes.SIMA_CUSTOMER_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REGISTER_CUSTOMER_OPERATION_TYPE, "عملیات ثبت مشتری سیما", SimaCodes.SIMA_CUSTOMER_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RECEIVED_SALE_INTEREST_RESPONSE_OPERATION_TYPE, "پاسخ سود روزانه به ازای یک برگ اوراق دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SECURITIES_RECEIVED_SECURITIES_FOR_SALE_RESPONSE_OPERATION_TYPE, "پاسخ موجودی قابل فروش اوراق دریافت شد", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_INTEREST_AMOUNT_RESPONSE_OPERATION_TYPE, "پاسخ دریافت مبلغ سود بازخرید از ابتدای دوره تا امروز", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESALE_INTEREST_AMOUNT_RESPONSE_OPERATION_TYPE, "پاسخ دریافت مبلغ سود بازفروش از ابتدای دوره تا امروز", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_PENALTY_AMOUNT_RESPONSE_OPERATION_TYPE, "پاسخ دریافت مبلغ جریمه بازخرید از ابتدای دوره تا امروز", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_TRANSACTION_CODE_OPERATION_TYPE, "عملیات مقداردهی شماره تراکنش در قرارداد سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_REVERSE_TRANSACTION_NUMBER_OPERATION_TYPE, "عملیات مقداردهی شماره تراکنش لغو در قرارداد سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_TRANSACTION_NUMBER_OPERATION_TYPE, "عملیات بروزرسانی شماره تراکنش صدور مجدد در قرارداد سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات به روز رسانی حساب سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات ایجاد حساب سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_SALE_CONTRACT_ON_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات ایجاد قرارداد فروش با حساب سیما", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_TRANSFER_FROM_CONTRACT_ON_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات انتقال اوراق از مشتری", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_TRANSFER_TO_CONTRACT_ON_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات ایجاد قرارداد انتقال به مشتری", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_RESALE_CONTRACT_ON_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات ایجاد قرارداد بازفروش", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_REDEMPTION_CONTRACT_ON_SIMA_ACCOUNT_RESPONSE_OPERATION_TYPE, "عملیات ایجاد قرارداد بازخرید", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_SECURITIES_PRINCIPAL_IBAN_OPERATION_TYPE, "عملیات به روز رسانی شبای اصل اوراق", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_SECURITIES_INTEREST_IBAN_OPERATION_TYPE, "عملیات به روز رسانی شبای سود اوراق", SimaCodes.SIMA_RESPONSE_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.DEPOSIT_INTEREST_MACRO_OPERATION_TYPE, "عملیات واریز سود اوراق سیما", SimaCodes.SIMA_MACRO_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.DEPOSIT_PRINCIPAL_MACRO_OPERATION_TYPE, "عملیات واریز اصل اوراق سیما", SimaCodes.SIMA_MACRO_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_GET_ALLOCATED_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اطلاعات اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SEND_REQUEST_OPERATION_TYPE, "ارسال درخواست سیما به GT", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_FAILED_SEND_REQUEST_OPERATION_TYPE, "ارسال ناموفق درخواست سیما به GT", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_GET_SIMA_SECURITIES_COUPONS_DATE_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت کوپن های اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_SECURITIES_FOR_SAlE_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت موجودی قابل فروش اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_SECURITIES_FOR_RESAlE_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اوراق قابل بازفروش اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_SECURITIES_FOR_TRANSFER_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اوراق قابل انتقال اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_SECURITIES_FOR_REDEMPTION_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اوراق قابل بازخرید اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_SALE_INTEREST_FOR_ONE_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اطلاعات سود روزانه فروش یک برگ اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_REDEMPTION_INTEREST_FOR_ONE_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اطلاعات سود روزانه بازخرید یک برگ اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_RESALE_INTEREST_FOR_ONE_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اطلاعات سود روزانه بازفروش یک برگ اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_SALE_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست فروش اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_UPDATE_CUSTOMER_IBAN_REQUEST_OPERATION_TYPE, "ارسال درخواست بروزرسانی شماره شبا مشتری", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_RESALE_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست بازفروش اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_TRANSFER_SECURITIES_REQUEST_OPERATION_TYPE, "ارسال درخواست انتقال اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_REDEMPTION_REQUEST_OPERATION_TYPE, "ارسال درخواست بازخرید اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_PARTIAL_BLOCK_ACCOUNT_REQUEST_OPERATION_TYPE, "ارسال درخواست مسدود کردن بخشی از حساب", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_BLOCK_ACCOUNT_REQUEST_OPERATION_TYPE, "ارسال درخواست مسدود کردن کل حساب", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_UNBLOCK_ACCOUNT_REQUEST_OPERATION_TYPE, "ارسال درخواست رفع مسدود کردن کل حساب", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_PARTIAL_UNBLOCK_ACCOUNT_REQUEST_OPERATION_TYPE, "ارسال درخواست رفع مسدود کردن بخشی از حساب", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_GET_ACCOUNT_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت اطلاعات حساب سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_CREATE_PERSON_REQUEST_OPERATION_TYPE, "ارسال درخواست ایحاد مشتری حقیقی سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_CREATE_CUSTOMER_REQUEST_OPERATION_TYPE, "ارسال درخواست ایحاد مشتری سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_CREATE_ORGANIZATION_REQUEST_OPERATION_TYPE, "ارسال درخواست ایحاد مشتری حقوقی سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_UPDATE_PERSON_REQUEST_OPERATION_TYPE, "ارسال درخواست به روز رسانی مشتری حقیقی سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_UPDATE_ORGANIZATION_REQUEST_OPERATION_TYPE, "ارسال درخواست به روز رسانی مشتری حقوقی سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_GET_PERSON_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت مشتری حقیقی سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_GET_ORGANIZATION_REQUEST_OPERATION_TYPE, "ارسال درخواست دریافت مشتری حقوقی سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_BLOCK_CUSTOMER_REQUEST_OPERATION_TYPE, "ارسال درخواست مسدود کردن مشتری سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_UNBLOCK_CUSTOMER_REQUEST_OPERATION_TYPE, "ارسال درخواست رفع مسدودی مشتری سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_IS_PARTY_BLOCKED_REQUEST_OPERATION_TYPE, "ارسال درخواست بررسی مسدودی مشتری سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_UPDATE_AGENT_IBAN_REQUEST_OPERATION_TYPE, "ارسال درخواست به روز رسانی شبای اوراق", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REGISTER_CONTRACT_OPERATION_TYPE, "ثبت قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_PING_REQUEST_OPERATION_TYPE, "ارسال درخواست پینگ سیما", SimaCodes.SIMA_REQUEST_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_STATUS_OPERATION_TYPE, "بروزرسانی وضعیت قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_AMOUNT_OPERATION_TYPE, "بروزرسانی مبلغ قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.UPDATE_SIMA_CONTRACT_IBAN_OPERATION_TYPE, "بروزرسانی شماره شبا قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_INTEREST_AMOUNT_OPERATION_TYPE, "بروزرسانی سود قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_TRANSACTION_ID_OPERATION_TYPE, "بروزرسانی شناسه تراکنش دریافتی از سیما", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_ACCOUNT_OPERATION_TYPE, "بروزرسانی حساب قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_CONTRACT_BRANCH_DETAIL_OPERATION_TYPE, "بروزرسانی اطلاعات سود و جریمه قرارداد بازخرید", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESALE_CONTRACT_RECEIVE_RESPONSE_OPERATION_TYPE, "دریافت پاسخ قرارداد بازفروش", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_RESALE_CONTRACT_OPERATION_TYPE, "ایجاد قرارداد بازفروش", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ADD_SIMA_SALE_CONTRACT_OPERATION_TYPE, "ایجاد قرارداد فروش", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SALE_CONTRACT_RECEIVE_RESPONSE_OPERATION_TYPE, "دریافت پاسخ قرارداد فروش", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SEND_SIMA_REVERSE_CONTRACT_REQUEST_OPERATION_TYPE, "ارسال درخواست لغو قرارداد", SimaCodes.SIMA_CONTRACT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_ACCOUNT_STATUS_OPERATION_TYPE, "به روز رسانی وضعیت حساب", SimaCodes.SIMA_ACCOUNT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_ACCOUNT_AVAILABLE_BALANCE_OPERATION_TYPE, "به روز رسانی مانده قابل برداشت حساب", SimaCodes.SIMA_ACCOUNT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_ACCOUNT_BLOCK_BALANCE_OPERATION_TYPE, "به روز رسانی مبلغ مسدودی حساب", SimaCodes.SIMA_ACCOUNT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CHANGE_ACCOUNT_TOTAL_BALANCE_OPERATION_TYPE, "به روز رسانی مانده حساب", SimaCodes.SIMA_ACCOUNT_OPERATION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SALE_CONTRACT_ACTION_TYPE, "فروش اوراق", SimaCodes.SIMA_CONTRACT_ACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_RESALE_CONTRACT_ACTION_TYPE, "بازفروش اوراق", SimaCodes.SIMA_CONTRACT_ACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_REDEMPTION_CONTRACT_ACTION_TYPE, "بازخرید اوراق", SimaCodes.SIMA_CONTRACT_ACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TRANSFER_CONTRACT_ACTION_TYPE, "انتقال اوراق", SimaCodes.SIMA_CONTRACT_ACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CUSTOMER_STATUS_CHANGED_FIELD, "وضعیت مشتری سیما", SimaCodes.SIMA_CUSTOMER_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_MONTHLY_INTEREST_PAYMENT, "پرداخت سود ماهانه", SimaCodes.SIMA_INTEREST_PAYMENT_INTERVAL_UNIT));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_YEARLY_INTEREST_PAYMENT, "پرداخت سود سالانه", SimaCodes.SIMA_INTEREST_PAYMENT_INTERVAL_UNIT));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_REDEMPTION_INTEREST_AMOUNT_CHANGED_FIELD, "فیلد مبلغ سود بازخرید", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_RESALE_INTEREST_AMOUNT_CHANGED_FIELD, "فیلد مبلغ سود بازفروش", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_REDEMPTION_PENALTY_AMOUNT_CHANGED_FIELD, "فیلد مبلغ جریمه بازخرید", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_STATUS_CHANGED_FIELD, "فیلد وضعیت قرارداد", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_TRANSACTION_CODE_CHANGED_FIELD, "فیلد شماره تراکنش", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_REVERSE_TRANSACTION_NUMBER_CHANGED_FIELD, "فیلد شماره تراکنش لغو", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_TRANSACTION_NUMBER_CHANGED_FIELD, "فیلد شماره تراکنش صدور مجدد", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ACCOUNT_STATUS_CHANGED_FIELD, "فیلد وضعیت حساب", SimaCodes.SIMA_ACCOUNT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ACCOUNT_AVAILABLE_BALANCE_CHANGED_FIELD, "فیلد مانده قابل برداشت حساب", SimaCodes.SIMA_ACCOUNT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ACCOUNT_BLOCK_BALANCE_CHANGED_FIELD, "فیلد مبلغ مسدودی حساب", SimaCodes.SIMA_ACCOUNT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_ACCOUNT_TOTAL_BALANCE_CHANGED_FIELD, "فیلد مانده حساب", SimaCodes.SIMA_ACCOUNT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_TRANSACTION_ID_CHANGED_FIELD, "شناسه تراکنش سیما", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_BRANCH_DETAIL_CHANGED_FIELD, "اطلاعات سود و جریمه قرارداد بازخرید", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_ACCOUNT_CHANGED_FIELD, "حساب قرارداد", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_AMOUNT_CHANGED_FIELD, "مبلغ قرارداد", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_IBAN_CHANGED_FIELD, "شماره شبا قرارداد", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_CONTRACT_INTEREST_AMOUNT_CHANGED_FIELD, "سود قرارداد", SimaCodes.SIMA_CONTRACT_CHANGED_FIELD));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PARTIAL_BLOCK_ACCOUNT_TYPE, "مسدود بخشی", SimaCodes.SIMA_BLOCK_OR_UNBLOCK_ACCOUNT_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TOTAL_BLOCK_ACCOUNT_TYPE, "مسدود کل", SimaCodes.SIMA_BLOCK_OR_UNBLOCK_ACCOUNT_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TOTAL_UNBLOCK_ACCOUNT_TYPE, "رفع مسدود کل", SimaCodes.SIMA_BLOCK_OR_UNBLOCK_ACCOUNT_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PARTIAL_UNBLOCK_ACCOUNT_TYPE, "رفع مسدود بخشی", SimaCodes.SIMA_BLOCK_OR_UNBLOCK_ACCOUNT_TYPES));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.PUBLISHER_TRADING_SOURCE, "منبع ناشر", SimaCodes.SIMA_TRADING_SOURCE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.AGENT_TRADING_SOURCE, "منبع عامل", SimaCodes.SIMA_TRADING_SOURCE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_PRINCIPAL_IBAN_TYPE, "شبای پرداخت اصل اوراق", SimaCodes.SIMA_IBAN_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_INTEREST_IBAN_TYPE, "شبای پرداخت سود اوراق", SimaCodes.SIMA_IBAN_TYPE));
        /**
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_UPDATE_RESALE_AND_REDEMPTION_INTEREST_CONTRACT, "ماکرو فراخوانی مجدد سود بازخرید و بازفروش", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_FIX_CONFLICT_OF_SIMA_SALE_TRANSACTIONS, "ماکرو دریافت گزارش روزانه تراکنش های فروش سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_FIX_CONFLICT_OF_SIMA_RESALE_TRANSACTIONS, "ماکرو دریافت گزارش روزانه تراکنش های بازفروش سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_FIX_CONFLICT_OF_SIMA_REDEMPTION_TRANSACTIONS, "ماکرو دریافت گزارش روزانه تراکنش های بازخرید سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_FIX_CONFLICT_OF_SIMA_TRANSFER_TRANSACTIONS, "ماکرو دریافت گزارش روزانه تراکنش های انتقال سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_FIX_CONFLICT_OF_SIMA_REVERSE_TRANSACTIONS, "ماکرو دریافت گزارش روزانه تراکنش های بازگشتی سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_FIX_CONFLICT_OF_SIMA_BLOCK_ACCOUNTS, "ماکرو دریافت گزارش روزانه مسدودی های حساب سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MACRO_DEPOSIT_SIMA_INTEREST_PRINCIPAL, "ماکرو واریز اصل و سود اوراق سیما", "MONITOR_SEQUENCE_OPERATION"));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.NOT_RECEIVED_FAILED_SIMA_RESPONSE, "اجرای مین بررسی قراردادهایی با پاسخ منفی- پاسخ به FCB نرسیده", SimaCodes.FILE_RESULT_TYPE));
         */
        /**
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_SALE_SIMA_SECURITIES, "صدور سند فروش اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_RESALE_SIMA_SECURITIES, "صدور سند بازفروش اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_REDEMPTION_SIMA_SECURITIES, "صدور سند بازخرید اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_TRANSFER_SIMA_SECURITIES, "صدور سند انتقال اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_REVERSE_SALE_SIMA_SECURITIES, "صدور سند لغو قرارداد فروش اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_REVERSE_RESALE_SIMA_SECURITIES, "صدور سند لغو قرارداد بازفروش اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_REVERSE_REDEMPTION_SIMA_SECURITIES, "صدور سند لغو قرارداد بازخرید اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_REVERSE_TRANSFER_SIMA_SECURITIES, "صدور سند لغو قرارداد انتقال اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_DEPOSIT_SIMA_PRINCIPAL, "صدور سند واریز اصل اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_TR_TY_DEPOSIT_SIMA_INTEREST, "صدور سند واریز سود اوراق سیما", SharedCodes.META_DATA_TRANSACTION_TYPE));
         */
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_DEPOSIT_INTEREST_SUCCESSFUL_STATUS, "واریز اصل/سود موفق", SimaCodes.SIMA_DEPOSIT_INTEREST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_DEPOSIT_INTEREST_FAILED_STATUS, "واریز اصل/سود ناموفق", SimaCodes.SIMA_DEPOSIT_INTEREST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_DEPOSIT_INTEREST_IN_PROGRESS_STATUS, "واریز اصل/سود در حال پردازش", SimaCodes.SIMA_DEPOSIT_INTEREST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.CONFLICT_FOUND_IN_DAILY_REPORT_MACRO_STATUS, "دارای مغایرت", SimaCodes.DAILY_REPORT_MACRO_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.CONFLICT_NOT_FOUND_IN_DAILY_REPORT_MACRO_STATUS, "عدم مغایرت", SimaCodes.DAILY_REPORT_MACRO_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.ERROR_IN_FIXING_CONFLICT_IN_DAILY_REPORT_MACRO_STATUS, "خطا در بررسی مغایرت", SimaCodes.DAILY_REPORT_MACRO_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.TRANSFER_REPORT, "گزارش انتقال", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SALE_REPORT, "گزارش فروش", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.RESALE_REPORT, "گزارش بازفروش", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.INTEREST_REPORT, "سود های واریزی", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.BLOCK_REPORT, "گزارش انسداد", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.PRINCIPAL_REPORT, "گزارش واریز اصل", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.REVERSE_REPORT, "گزارش لغو قرارداد", SimaCodes.SIMA_REPORT_FILE_TYPE));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.REDEMPTION_REPORT, "گزارش باز خرید", SimaCodes.SIMA_REPORT_FILE_TYPE));
        /**
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SYSTEM_META_DATA, "اطلاعات سند سیما", GLCodes.SYSTEM_META_DATA));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SYSTEM_META_DATA_SIMA_ACCOUNT_ID, "شناسه حساب سیما مرتبط با سند", GLCodes.SYSTEM_META_DATA));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SYSTEM_META_DATA_SIMA_CONTRACT_ID, "شناسه قرارداد سیما مرتبط یا سند", GLCodes.SYSTEM_META_DATA));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SYSTEM_META_DATA_BUYER_SIMA_ACCOUNT_ID, "شناسه حساب سیما (خریدار) مرتبط با سند", GLCodes.SYSTEM_META_DATA));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.SIMA_SYSTEM_META_DATA_BUYER_CREDITOR_ACCOUNT_NUMBER, "شماره حساب سیما مرتبط با سند", GLCodes.SYSTEM_META_DATA));
         */
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MQ_REQUEST_PROCEED, "پردازش شده", SimaCodes.MQ_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MQ_REQUEST_NOT_PROCEED, "پردازش نشده", SimaCodes.MQ_REQUEST_STATUS));
        constCategoryElements.add(new MainConstCategoryElement(SimaCodes.MQ_REQUEST_INVALID_FORMAT, "فرمت نامعتبر", SimaCodes.MQ_REQUEST_STATUS));

        constCategoryElements.stream().forEach(c -> {
            Optional<Category> optionalCategory = categoryRepository.findByName(c.getCategoryName());
            if (optionalCategory.isPresent()) {
                Optional<ConstantCategoryElement> optionalConstantCategoryElement = constantCategoryRepository.findByCode(c.getCode());
                if (optionalConstantCategoryElement.isEmpty()) {
                    ConstantCategoryElement constantCategoryElement = new ConstantCategoryElement();
                    constantCategoryElement.setCode(c.getCode());
                    constantCategoryElement.setValue(c.getValue());
                    constantCategoryElement.setCategory(optionalCategory.get());
                    constantCategoryRepository.save(constantCategoryElement);
                }
            } else {
                logger.info("could not find category " + c.getCategoryName() + " !");
            }
        });
    }
}
