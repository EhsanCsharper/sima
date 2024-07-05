<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="application/javascript">

    function showBlockCustomerModal(customerIdentifier, customerIdentifierType, customerName) {
        var blockCustomerModal = new bootstrap.Modal(document.getElementById('blockCustomerModal'));
        document.getElementById('customerNameInput').value = customerName;
        blockCustomerModal.show();
    }
</script>

<!-- Modal -->
<div class="modal fade" id="blockCustomerModal" tabindex="-1" aria-labelledby="blockCustomerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header sima-modal-header">
                <h1 class="modal-title fs-5" id="blockCustomerModalLabel">انسداد مشتری</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="" method="post" id="blockCustomerForm">
                    <input type="hidden" id="customerIdentifier" name="identifier" />
                    <input type="hidden" id="customerIdentifierType" name="identifierType" />
                    <div class="row mb-3 form-group">
                        <label for="customerNameInput" class="col-sm-4 col-form-label">نام مشتری</label>
                        <div class="col-sm-8">
                            <input type="text" readonly disabled class="form-control input-sm" id="customerNameInput" name="customerName" />
                        </div>
                    </div>
                    <div class="row">
                        <label for="descriptionInput" class="col-sm-4 col-form-label">توضیحات</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" id="descriptionInput" name="description" rows="6"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">انصراف</button>
                <button type="button" class="btn btn-dark">تایید</button>
            </div>
        </div>
    </div>
</div>
