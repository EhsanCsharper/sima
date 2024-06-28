<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>

<main class="col-md-9 ms-sm-auto col-lg-9 px-md-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">مدیریت مشتریان</h1>
    </div>

    <!--add search from-->
    <form>
        <div class="row mb-3 form-group">
            <label for="inputSelect" class="col-sm-2 col-form-label">نوع شناسه مشتری</label>
            <div class="col-sm-4">
                <select class="form-select form-select-sm" id="inputSelect">
                    <option selected>---</option>
                    <option value="1">کد ملی</option>
                    <option value="2">کد ملی</option>
                    <option value="3">کد ملی</option>
                </select>
            </div>
            <label for="customerIdInput" class="col-sm-2 col-form-label">شناسه مشتری</label>
            <div class="col-sm-4">
                <input type="text" class="form-control input-sm" id="customerIdInput">
            </div>
        </div>
        <div class="row mb-3">
            <label for="customerStatusInputSelect" class="col-sm-2 col-form-label">وضعیت مشتری</label>
            <div class="col-sm-4 ">
                <select class="form-select form-select-sm" id="customerStatusInputSelect">
                    <option selected>---</option>
                    <option value="1">مسدود</option>
                    <option value="2">فعال</option>
                </select>
            </div>
            <label for="customerNoInput" class="col-sm-2 col-form-label">شماره مشتری</label>
            <div class="col-sm-4">
                <input type="text" class="form-control input-sm" id="customerNoInput">
            </div>
        </div>
        <div class="container text-center">
            <button type="submit" class="btn btn-dark">جستجو</button>
        </div>
    </form>

    <div class="border-top" style="margin-top: 20px;"></div>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">عنوان</th>
                <th scope="col">عنوان</th>
                <th scope="col">عنوان</th>
                <th scope="col">عنوان</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            <tr>
                <td>1,001</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
                <td>عنوان</td>
            </tr>
            </tbody>
        </table>
    </div>
</main>

<%@ include file="layout/footer.jsp"%>