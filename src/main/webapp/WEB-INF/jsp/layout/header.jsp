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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="/static/css/bootstrap.rtl.min.css" rel="stylesheet">

    <style>

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

        .sima-table-btn {
            background-color: inherit;
            border: none;
            font-size: 14px;
            cursor: pointer;
            width: 25px;
            padding: 2px;
        }

        /* Darker background on mouse-over */
        .sima-table-btn:hover {
            color: #fff;
            background-color: #1c1f23;
            border-color: #1a1e21;
        }

        .sima-modal-header {
            background-color: #f8f9fa;
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.rtl.css" rel="stylesheet">

    <script src="/static/js/jquery-3.7.1.min.js"></script>
</head>
<body>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-3 me-0 px-3" href="#">سامانه سیما</a>
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
