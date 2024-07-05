<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty searchResult.result}">
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col"></th>   <%--block customer icon--%>
                <th scope="col"></th>   <%--unblock customer icon--%>
                <th scope="col"></th>   <%--isParty blocked icon--%>
                <th scope="col"></th>   <%--view customer info icon--%>
                <th scope="col"></th>   <%--view customer requests icon--%>
                <th scope="col">نوع شناسه مشتری</th>
                <th scope="col">شناسه مشتری</th>
                <th scope="col">نوع مشتری</th>
                <th scope="col">نام مشتری</th>
                <th scope="col">شماره مشتری</th>
                <th scope="col">وضعیت مشتری</th>
                <th scope="col">تاریخ ثبت مشتری</th>
                <th scope="col">تاریخ آخرین تغییر</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${searchResult.result}" var="customer" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>
                            <%--<cmp:button id="blockCustomer${customer.identifier}" icon="lock"
                                           onClick="parent.showBlockDialog('${customer.identifier}', '${customer.identifierType.id}', '${customer.name}')"
                                           tooltip="انسداد مشتری"/>--%>
                        <button class="btn sima-table-btn" onclick="showBlockCustomerModal(${customer.identifier}, ${customer.identifierType.id}, '${customer.name}')"
                                <c:if test="${hasPermissionToBlockCustomer eq false or customer.status.code ne 'SIMA_CUSTOMER_ACTIVE_STATUS'}">
                                    disabled
                                </c:if>
                        >
                            <i class="bi bi-lock" title="انسداد مشتری"></i>
                        </button>
                    </td>
                    <td>
                            <%--<cmp:button id="unblockCustomer${customer.identifier}" icon="unlock"
                                            onClick="parent.unblockCustomer('${customer.identifier}', '${customer.identifierType.id}')"
                                            tooltip="رفع انسداد مشتری"/>--%>
                        <button class="btn sima-table-btn"
                                <c:if test="${hasPermissionToUnBlockCustomer eq false or customer.status.code ne 'SIMA_CUSTOMER_BLOCK_STATUS'}">
                                    disabled
                                </c:if>
                        >
                            <i class="bi bi-unlock" title="رفع انسداد مشتری"></i>
                        </button>
                    </td>
                    <td>
                            <%--<cmp:button id="isPartyBlocked${customer.identifier}" icon="question-circle"
                                        onClick="parent.isPartyBlocked('${customer.identifier}', '${customer.identifierType.id}')"
                                        tooltip="بررسی وضعیت مسدودی مشتری"/>--%>
                        <button class="btn sima-table-btn" onclick="isPartyBlocked(${customer.identifier}, '${customer.identifierType.code}', '${customer.name}')">
                            <i class="bi bi-question-circle" title="بررسی وضعیت مسدودی مشتری"></i>
                        </button>
                    </td>
                    <td>
                        <c:if test="${customer.status.code eq 'SIMA_CUSTOMER_ACTIVE_STATUS' or customer.status.code eq 'SIMA_CUSTOMER_BLOCK_STATUS'}">
                            <%--<cmp:button id="viewCustomer${customer.identifier}" icon="eye"
                                        onClick="parent.getCustomer('${customer.identifier}', '${customer.identifierType.id}')"
                                        tooltip="مشاهده اطلاعات مشتری"/>--%>
                        <button class="btn sima-table-btn"><i class="bi bi-eye" title="مشاهده اطلاعات مشتری"></i></button>
                        </c:if>
                    </td>
                    <td>
                        <button class="btn sima-table-btn"><i class="bi bi-file-earmark-text" title="مشاهده درخواست های مشتری"></i></button>
                    </td>
                    <td>${customer.identifierType.value}</td>
                    <td>${customer.identifier}</td>
                    <td>
                        <c:if test="${customer.real}">
                            حقیقی
                        </c:if>
                        <c:if test="${!customer.real}">
                            حقوقی
                        </c:if>
                    </td>
                    <td>${customer.name}</td>
                    <td>${customer.customerNumber}</td>
                    <td>${customer.status.value}</td>
                    <td>${customer.creationDateTime}</td>
                    <td>${customer.lastModifiedDateTime}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%@ include file="../layout/paging.jsp"%>
    </div>
    <%@ include file="block-customer-modal.jsp"%>
    <%@ include file="is-party-blocked.jsp"%>
</c:if>