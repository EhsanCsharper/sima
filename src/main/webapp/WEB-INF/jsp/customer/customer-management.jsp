<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../layout/header.jsp"%>
<script type="application/javascript">
    function searchForm(pageIndex) {
        if (pageIndex > -1) {
            document.getElementById('pageIndex').value = pageIndex;
            document.getElementById("searchForm").submit();
        }
    }
</script>

<main class="col-md-9 ms-sm-auto col-lg-9 px-md-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">مدیریت مشتریان</h1>
    </div>

    <!--add search from-->
    <form id="searchForm" action="/customers" method="get">
        <div class="row mb-3 form-group">
            <label for="inputSelect" class="col-sm-2 col-form-label">نوع شناسه مشتری</label>
            <div class="col-sm-4">
                <select class="form-select form-select-sm" id="inputSelect" name="identifierTypeCode">
                    <option value="0">---</option>
                    <c:forEach items="${identificationTypes}" var="item">
                        <option value=${item.code}
                                    <c:if test="${searchDTO.identifierTypeCode eq item.code}">selected</c:if>
                        >${item.value}</option>
                    </c:forEach>
                </select>
            </div>
            <label for="customerIdInput" class="col-sm-2 col-form-label">شناسه مشتری</label>
            <div class="col-sm-4">
                <input type="text" class="form-control input-sm" id="customerIdInput" name="identifier" value="${searchDTO.identifier}">
            </div>
        </div>
        <div class="row mb-3">
            <label for="customerStatusInputSelect" class="col-sm-2 col-form-label">وضعیت مشتری</label>
            <div class="col-sm-4 ">
                <select class="form-select form-select-sm" id="customerStatusInputSelect" name="statusCode">
                    <option value="0" selected>---</option>
                    <c:forEach items="${customerStatusTypes}" var="item">
                        <option value=${item.code}
                                        <c:if test="${searchDTO.statusCode eq item.code}">selected</c:if>
                        >${item.value}</option>
                    </c:forEach>
                </select>
            </div>
            <label for="customerNoInput" class="col-sm-2 col-form-label">شماره مشتری</label>
            <div class="col-sm-4">
                <input type="text" class="form-control input-sm" id="customerNoInput" name="customerNumber" value="${searchDTO.customerNumber}">
            </div>
        </div>
        <div class="container text-center">
            <input type="submit" class="btn btn-dark" value="جستجو"/>
        </div>
        <input type="hidden" name="pageIndex" id="pageIndex" value="0"/>
        <input type="hidden" name="pageSize" id="pageSize" value="${searchResult.pageSize}"/>
        <input type="hidden" name="orderBy" id="orderBy" value="customer"/>
    </form>

    <div class="border-top" style="margin-top: 20px;"></div>
    <%@ include file="search-result.jsp"%>
</main>

<%@ include file="../layout/footer.jsp"%>