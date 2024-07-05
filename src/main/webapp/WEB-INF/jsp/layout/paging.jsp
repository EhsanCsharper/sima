<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav aria-label="result">
    <ul class="pagination">
        <li class="page-item <c:if test="${searchResult.pageNumber == 0}">disabled</c:if> ">
            <a class="page-link" href="#" tabindex="-1"
                    <c:if test="${searchResult.pageNumber > 0}">
                        onclick="searchForm(${searchResult.pageNumber - 1})"
                    </c:if>
            >قبلی</a>
        </li>
        <c:forEach begin="0" end="${searchResult.pageCount - 1}" varStatus="loop">
            <li class="page-item <c:if test="${searchResult.pageNumber == loop.index}">active</c:if> ">
                <a class="page-link" href="#"
                        <c:if test="${searchResult.pageNumber != loop.index}">
                            onclick="searchForm(${loop.index})"
                        </c:if>
                >${loop.index + 1}
                </a>
            </li>
        </c:forEach>
        <li class="page-item
                                    <c:if test="${searchResult.pageNumber + 1 >= searchResult.pageCount}">disabled</c:if> ">
            <a class="page-link" href="#"
                    <c:if test="${searchResult.pageNumber + 1 < searchResult.pageCount}">
                        onclick="searchForm(${searchResult.pageNumber + 1})"
                    </c:if>
            >بعدی</a>
        </li>
    </ul>
</nav>