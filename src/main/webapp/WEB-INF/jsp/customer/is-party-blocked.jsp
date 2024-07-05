<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="application/javascript">

    function isPartyBlocked(customerIdentifier, customerIdentifierType, customerName) {
        var isPartyBlockedModal = new bootstrap.Modal(document.getElementById('isPartyBlockedModal'),{backdrop: 'static', keyboard: false});
        document.getElementById('isPartyBlockedForm-customerNameInput').value = customerName;
        document.getElementById('isPartyBlockedForm-customerIdentifier').value = customerIdentifier;
        document.getElementById('isPartyBlockedForm-customerIdentifierType').value = customerIdentifierType;
        isPartyBlockedModal.show();
    }

    $(document).ready(function () {
        $( "#isPartyBlockedFormSubmitBtn").on( "click", function( event ) {
            $('#isPartyBlockedFormSubmitBtn').attr('disabled', true);
            $('#isPartyBlockedModal-spinner').show();
            $('#isPartyBlockedModal-alert').hide();
            var form = $("#isPartyBlockedForm");
            $.post(form.attr('action'), form.serialize())
                .done(function( data ) {
                    if (data.rsCode !== 'SIMA_200') {
                        //$('#isPartyBlockedModal-spinner').hide();
                        //$('#isPartyBlockedModal-alert').show();
                        $('#isPartyBlockedModal-alert').html(data.errorMessage);
                        $('#isPartyBlockedFormSubmitBtn').attr('disabled', false);
                    }
                });
        } );
    });


</script>

<!-- Modal -->
<div class="modal fade" id="isPartyBlockedModal" tabindex="-1" aria-labelledby="isPartyBlockedModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header sima-modal-header">
                <h1 class="modal-title fs-5" id="isPartyBlockedModalLabel">بررسی وضعیت انسداد مشتری</h1>
                <button id="isPartyBlockedModal-closeBtn" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/customers/isPartyBlocked" method="post" id="isPartyBlockedForm">
                    <input type="hidden" id="isPartyBlockedForm-customerIdentifier" name="identifier" />
                    <input type="hidden" id="isPartyBlockedForm-customerIdentifierType" name="identifierTypeCode" />
                    <div class="row mb-3 form-group">
                        <label for="isPartyBlockedForm-customerNameInput" class="col-sm-4 col-form-label">نام مشتری</label>
                        <div class="col-sm-8">
                            <input type="text" readonly disabled class="form-control input-sm" id="isPartyBlockedForm-customerNameInput" name="customerName" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-8">
                            <button class="btn btn-dark" type="button" disabled id="isPartyBlockedModal-spinner" style="display: none;">
                                <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                <span class="sr-only">درحال ارسال ارطلاعات به بانک مرکزی, لطفا چند لحظه صبر کنید...</span>
                            </button>
                            <div class=" alert alert-dark" role="alert" id="isPartyBlockedModal-alert">
                                ارسال درخواست بررسی وضعیت انسداد مشتری برای بانک مرکزی
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="isPartyBlockedModal-cancelBtn">انصراف</button>
                <button type="button" class="btn btn-dark" id="isPartyBlockedFormSubmitBtn">تایید</button>
            </div>
        </div>
    </div>
</div>
