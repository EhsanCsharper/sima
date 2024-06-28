<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="سامانه سیما">
    <meta name="author" content="DOTIN-CORE-DEPOSIT-TEAM">
    <meta name="generator" content="DOTIN">
    <title>سامانه سیما</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard-rtl/">


    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.rtl.min.css" rel="stylesheet">

    <style>

        .btn {
            width: 90px;
            font-size: 14px;
        }

        .form-control {
            height: 31px;
        }

        .col-form-label {
            direction: ltr;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.rtl.css" rel="stylesheet">
</head>
<body>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">سامانه سیما</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
            data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" href="#">خروج</a>
        </div>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <%@ include file="sidebar.jsp"%>
