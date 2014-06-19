
    var refreshActive = true;

	function refreshEventGrid() {
    	if (refreshActive) {
		    $.ajax({
    			url : 'eventGridRefresh',
    			success : function(data) {
    				$('#eventGrid').html(data);
    			 }
    			});
    	    }
	}

	function goSearchEventGrid() {
	        var paddedEventNumber = "eventNumber=" + $('#eventNumber').val();
	        refreshActive=false;

    		$.ajax({
    		    url : 'searchEventGrid',
    		    type : 'POST',
    			data : paddedEventNumber,
    			success : function(data) {
    				$('#eventGrid').html(data);
    			},
    			error: function(data, errorMessage) {
    			    alert('Invalid Search Data: ' + errorMessage);
    			}
    		});
    }

    function resetEventSearch() {
            $('#eventNumber').val('');
            refreshActive = true;
            refreshEventGrid();
    }

    $(document).ready(function() {
        $('#eventSearchForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            submitHandler: function(validator, form) {
                // do nothing
            },
            fields: {
                eventNumber: {
                    validators: {
                        integer: {
                            message: 'The value is not an integer'
                        },
                        notEmpty: {
                            message: 'Number required'
                        }
                    }
                }
            }
        });
    });
