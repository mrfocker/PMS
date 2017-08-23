$(function() {
    $("#tabs").tabs();
    
    $("#paperPassDeadline").datepicker();
    $("#blindJudgeDeadline").datepicker();
    $("#replyDeadline").datepicker();
    
    $('#dt1').dataTable( {
        "sPaginationType": "full_numbers"
    });
    
    $('#dt2').dataTable( {
        "sPaginationType": "full_numbers"
    });
    
    $('#dtPaperResult').dataTable( {
        "sPaginationType": "full_numbers"
    });
    
    $('#dtBlindResult').dataTable( {
        "sPaginationType": "full_numbers"
    });
    
    $('#dtReplyResult').dataTable( {
        "sPaginationType": "full_numbers"
    });
    
    $('#dtStuRequest').dataTable( {
    	"bJQueryUI": true,
        "sPaginationType": "full_numbers"
    });
    
    $('#dtStuReply').dataTable( {
    	"bJQueryUI": true,
        "sPaginationType": "full_numbers"
    });
});