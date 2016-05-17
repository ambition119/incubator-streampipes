//  =============
//  = Variables = 
//  ============= 
//var streamEndpointOptions = {
//    endpoint: ["Dot", {radius: 5}],
//    paintStyle: {fillStyle: "grey"},
//    connectorStyle: {strokeStyle: "grey", lineWidth: 4},
//    connector: "Straight",
//    isSource: true,
//    anchor: ["Perimeter", {shape: "Circle"}],
//    connectorOverlays: [
//        ["Arrow", {width: 25, length: 20, location: .5, id: "arrow"}],
//    ]
//};
//
//var sepaEndpointOptions = {
//    endpoint: ["Dot", {radius: 5}],
//    paintStyle: {fillStyle: "grey"},
//    connectorStyle: {strokeStyle: "grey", lineWidth: 4},
//    connector: "Straight",
//    isSource: true,
//    anchor: "Right",
//    connectorOverlays: [
//        ["Arrow", {width: 25, length: 20, location: .5, id: "arrow"}],
//    ]
//};
//
//var leftTargetPointOptions = {
//    endpoint: "Rectangle",
//    paintStyle: {fillStyle: "grey"},
//    anchor: "Left",
//    isTarget: true
//};



/**
 * Handles everything that has to do with the assembly area, and elements in it
 */
//function initAssembly() {
//
//    $('#clear').click(clearAssembly);
//
//    $('#assembly').droppable({
//        tolerance: "fit",
//        drop: function (element, ui) {
//            if (ui.draggable.hasClass('draggable-icon')) {
//                if (ui.draggable.data("JSON") == null) {
//                    alert("No JSON - Data for Dropped element");
//                    return false;
//                }
//                //Neues Container Element für Icon / identicon erstellen
//                var $newState = createNewAssemblyElement(ui.draggable.data("JSON"), getCoordinates(ui), false);
//
//                //Droppable Streams
//                if (ui.draggable.hasClass('stream')) {
//                    handleDroppedStream($newState, true);
//                    var tempPipeline = new Pipeline();
//                    tempPipeline.addElement($newState[0]);
//                    initRecs(tempPipeline, $newState);
//
//                    //$newState.hover(showRecButton, hideRecButton);
//
//                    //Droppable Sepas
//                } else if (ui.draggable.hasClass('sepa')) {
//                    handleDroppedSepa($newState, true);
//
//                    //Droppable Actions
//                } else if (ui.draggable.hasClass('action')) {
//                    handleDroppedAction($newState, true);
//                }
//                initTooltips();
//            }
//            jsPlumb.repaintEverything(true);
//        }
//
//    }); //End #assembly.droppable()
//}

//function addRecommendedButton($element) {
//    $("<span>")
//        .addClass("recommended-button")
//        .click(function (e) {
//            e.stopPropagation();
//            var $recList = $("ul", $element);
//            $recList.circleMenu('open');
//        })
//        .appendTo($element);
//}
//
//function showRecButton(e) {
//    $("span:not(.recommended-list,.recommended-item,.element-text-icon,.element-text-icon-small)", this).show();
//}
//function hideRecButton(e) {
//    $("span:not(.recommended-list,.recommended-item,.element-text-icon,.element-text-icon-small)", this).hide();
//}
//
//
//function getCoordinates(ui) {
//
//    var newPos = ui.helper.position();
//    var newTop = getDropPosition(ui.helper);
//
//    return {
//        'x': newPos.left,
//        'y': newTop
//    };
//}
//
//function createNewAssemblyElement(json, coordinates) {
//    var urlInvalid = false;
//
//    var $newState = $('<span>')
//        .data("JSON", $.extend(true, {}, json))
//        .appendTo('#assembly');
//    if (typeof json.DOM != "undefined") { //TODO TESTTEST
//        $newState.attr("id", json.DOM);
//        $newState.addClass('a'); //Flag so customize modal won't get triggered
//    }
//
//    jsPlumb.draggable($newState, {containment: 'parent'});
//
//    $newState
//        .css({'position': 'absolute', 'top': coordinates.y, 'left': coordinates.x})
//        .on("contextmenu", function (e) {
//            if ($(this).hasClass('stream')) {
//                $('#customize, #division ').hide();
//
//            } else {
//                $('#customize, #division ').show();
//            }
//            if ($(this).hasClass('ui-selected') && isConnected(this)){
//                $('#blockButton').text("Create Block from Selected");
//                $('#blockButton, #division1 ').show();
//            } else {
//                $('#blockButton, #division1 ').hide();
//            }
//            $('#assemblyContextMenu')
//                .data("invokedOn", $(e.target))
//                .show()
//                .css({
//                    position: "absolute",
//                    left: getLeftLocation(e, "assembly"),
//                    top: getTopLocation(e, "assembly")
//                });
//            ContextMenuClickHandler("assembly");
//            return false;
//        });
//
//    $("<img>")
//        .attr({
//            src: $newState.data('JSON').iconUrl
//        })
//        .error(function(){
//            $(".connectable-img", $newState).remove();
//            addTextIconToElement($newState, $newState.data("JSON").name);
//        });
//
//
//    if ($newState.data('JSON').iconUrl == null || urlInvalid) { //Kein icon in JSON angegeben
//
//        addTextIconToElement($newState, $newState.data('JSON').name);
//
//    } else {
//        $('<img>')
//            .attr({
//                src: json.iconUrl,
//                "data-toggle": "tooltip",
//                "data-placement": "top",
//                "data-delay": '{"show": 1000, "hide": 100}',
//                title: json.name
//            })
//            .addClass('connectable-img tt')
//
//            .appendTo($newState)
//
//            .data("JSON", $.extend(true, {}, json));
//    }
//
//    return $newState;
//}




//function handleDroppedStream($newState, endpoints) {
//
//    displaySepas();
//    $('#sepas').children().show();
//    $('#sepas').fadeTo(100, 1);
//
//    $newState
//        .addClass('connectable stream');
//
//    if (endpoints) {
//        jsPlumb.addEndpoint($newState, streamEndpointOptions);
//    }
//
//    //$newState.dblclick(function () {
//    //    jsPlumb.addEndpoint($newState, streamEndpointOptions);
//    //});
//
//
//    if ($('#assembly').children().hasClass('sepa')) {
//        $('#actionCollapse').attr("data-toggle", "collapse");
//        $('#actionCollapse').removeClass("disabled");
//    }
//
//}

//function handleDroppedSepa($newState, endpoints) {
//
//    $('#actions').children().remove();
//    displayActions();
//    $('#actions').children().show();
//    $('#actions').fadeTo(100, 1);
//    $newState
//        .addClass('connectable sepa');
//    if ($newState.data("JSON").staticProperties != null && !state.adjustingPipelineState && !$newState.data("options")) {
//        $newState
//            .addClass('disabled');
//    }
//
//    if (endpoints) {
//        if ($newState.data("JSON").inputNodes < 2) { //1 InputNode
//
//            jsPlumb.addEndpoint($newState, leftTargetPointOptions);
//        } else {
//            jsPlumb.addEndpoint($newState, getNewTargetPoint(0, 0.25));
//
//            jsPlumb.addEndpoint($newState, getNewTargetPoint(0, 0.75));
//        }
//        jsPlumb.addEndpoint($newState, sepaEndpointOptions);
//    }
//
//    //$newState.dblclick(function () {
//    //    jsPlumb.addEndpoint($newState, sepaEndpointOptions);
//    //});
//    return $newState;
//}

//function handleDroppedAction($newState, endpoints) {
//
//    $newState
//        .addClass("connectable action");
//    if ($newState.data("JSON").staticProperties != null && !state.adjustingPipelineState) {
//        $newState
//            .addClass('disabled');
//    }
//    if (endpoints) {
//        jsPlumb.addEndpoint($newState, leftTargetPointOptions);
//    }
//    return $newState;
//
//}

//function getNewTargetPoint(x, y) {
//    return {
//        endpoint: "Rectangle",
//        paintStyle: {fillStyle: "grey"},
//        anchor: [x, y, -1, 0],
//        isTarget: true
//    };
//}




///**
// * clears the Assembly of all elements
// */
//function clearAssembly() {
//    $('#assembly').children().not('#clear, #submit').remove();
//    jsPlumb.deleteEveryEndpoint();
//
//    $rootScope.state.adjustingPipelineState = false;
//}

//function createPartialPipeline(info) {
//    var pipelinePart = new Pipeline();
//    var element = info.target;
//
//    addElementToPartialPipeline(element, pipelinePart);
//    $rootScope.state.currentPipeline = pipelinePart;
//
//}

//function addElementToPartialPipeline(element, pipelinePart) {
//
//    pipelinePart.addElement(element);
//    var connections = jsPlumb.getConnections({target: element});
//    if (connections.length > 0) {
//        for (var i = 0, con; con = connections[i]; i++) {
//            addElementToPartialPipeline(con.source, pipelinePart);
//        }
//    }
//
//}

//function showAdjustingPipelineState(pipelineName) {
//    var text = 'Modifying Pipeline "' + pipelineName + '"'
//    $("<div>").attr("id", "adjustString").append($("<p>").text(text)).appendTo($('#assembly'));
//}
//function hideAdjustingPipelineState() {
//    $('#adjustString').hide();
//}


///**
// * Sends the pipeline to the server
// */
//function submit() {
//    var error = false;
//    var pipelineNew = new Pipeline();
//    var streamPresent = false;
//    var sepaPresent = false;
//    var actionPresent = false;
//
//
//
//    $('#assembly').find('.connectable, .block').each(function (i, element) {
//        var $element = $(element);
//
//        if (!isConnected(element)) {
//            error = true;
//
//            toastRightTop("error", "All elements must be connected", "Submit Error");
//        }
//
//        if ($element.hasClass('sepa')) {
//            sepaPresent = true;
//            if ($element.data("options")) {
//                pipelineNew.addElement(element);
//
//            } else if ($element.data("JSON").staticProperties != null) {
//                toastRightTop("error", "Please enter parameters for transparent elements (Right click -> Customize)", "Submit Error");
//                ;
//                error = true;
//
//            }
//        } else if ($element.hasClass('stream')) {
//            streamPresent = true;
//            pipelineNew.addElement(element);
//
//
//        } else if ($element.hasClass('action')) {
//            if (actionPresent) {
//                error = true;
//                toastRightTop("error", "More than one action element present in pipeline", "Submit Error");
//            } else {
//                actionPresent = true;
//                if ($element.data("JSON").staticProperties == null || $element.data("options")) {
//                    pipelineNew.addElement(element);
//                } else {
//                    toastRightTop("error", "Please enter parameters for transparent elements (Right click -> Customize)", "Submit Error");
//                    ;
//                    error = true;
//
//                }
//            }
//        } else if ($element.hasClass('block')) {
//            streamPresent = true;
//            sepaPresent = true;
//            pipelineNew.addElement(element);
//        }
//    });
//    if (!streamPresent) {
//        toastRightTop("error", "No stream element present in pipeline", "Submit Error");
//        error = true;
//    }
//    if (!sepaPresent) {
//        toastRightTop("error", "No sepa element present in pipeline", "Submit Error");
//        error = true;
//    }
//    if (!actionPresent) {
//        toastRightTop("error", "No action element present in pipeline", "Submit Error");
//        error = true;
//    }
//    if (!error) {
//
//        state.currentPipeline = pipelineNew;
//        openPipelineNameModal();
//
//
//    }
//}

//function openPipelineNameModal() {
//    if (state.adjustingPipelineState) {
//        var name = state.adjustingPipeline.name;
//        var descr = state.adjustingPipeline.description;
//
//        $("#nameInput").attr("value", name);
//        $("#descriptionInput").attr("value", descr);
//        $("#overwriteCheckbox").show();
//    }
//    $('#pipelineNameModal').modal('show');
//}

//function savePipelineName() {
//
//    var pipelineName = $('#pipelineNameForm').serializeArray();
//    if (pipelineName.length < 2) {
//        toastRightTop("error", "Please enter all parameters");
//        return false;
//    }
//
//    state.currentPipeline.name = pipelineName[0].value;
//    state.currentPipeline.description = pipelineName[1].value;
//
//    var overWrite;
//
//    if (!($("#overwriteCheckbox").css('display') == 'none')) {
//        overWrite = $("#overwriteCheckbox").prop("checked");
//    } else {
//        overWrite = false;
//    }
//    state.currentPipeline.send(overWrite);
//    //sendPipeline(true, overWrite);
//}

//function modifyPipeline(pipelineModifications) {
//    var id;
//
//    for (var i = 0, modification; modification = pipelineModifications[i]; i++) {
//        id = "#" + modification.domId;
//        if ($(id) !== "undefined") {
//            $(id).data("JSON").staticProperties = modification.staticProperties;
//        }
//        //clearCurrentElement();
//    }
//}


///**
// * saves the parameters in the current element's data with key "options"
// */
//function save() {
//
//    var options = $('#modalForm').serializeArray();
//    if (options.length < state.currentElement.data("JSON").staticProperties.length) {
//        toastRightTop("error", "Please enter all parameters");
//        return false;
//    }
//    for (var i = 0; i < options.length; i++) {
//        if (options[i].value == "") {
//            toastRightTop("error", "Please enter all parameters");
//            return false;
//        }
//    }
//
//    state.currentElement.data("options", true);
//    saveInStaticProperties(options);
//    state.currentElement.removeClass("disabled");
//    // state.currentElement.css("opacity", 1);
//}

//function saveInStaticProperties(options) {
//    for (var i = 0; i < options.length; i++) {
//        switch (state.currentElement.data("JSON").staticProperties[i].input.properties.elementType) {
//
//            case "RADIO_INPUT" :
//            case "SELECT_INPUT" :
//                for (var j = 0; j < state.currentElement.data("JSON").staticProperties[i].input.properties.options.length; j++) {
//                    if (state.currentElement.data("JSON").staticProperties[i].input.properties.options[j].humanDescription == options[i].value) {
//                        state.currentElement.data("JSON").staticProperties[i].input.properties.options[j].selected = true;
//                    } else {
//                        state.currentElement.data("JSON").staticProperties[i].input.properties.options[j].selected = false;
//                    }
//                }
//                continue;
//            case "CHECKBOX" :
//                for (var j = 0; j < state.currentElement.data("JSON").staticProperties[i].input.properties.options.length; j++) {
//                    if ($("#" + options[i].value + " #checkboxes-" + i + "-" + j).is(':checked')) {
//                        state.currentElement.data("JSON").staticProperties[i].input.properties.options[j].selected = true;
//                    } else {
//                        state.currentElement.data("JSON").staticProperties[i].input.properties.options[j].selected = false;
//                    }
//                }
//                continue;
//            case "TEXT_INPUT":
//                state.currentElement.data("JSON").staticProperties[i].input.properties.value = options[i].value;
//                continue;
//
//        }
//    }
//    toastRightTop("success", "Parameters saved");
//}

//function prepareCustomizeModal(element) {
//    state.currentElement = element;
//    var string = "";
//    // $('#savedOptions').children().not('strong').remove();
//    // if (element.data("modal") == null) {
//	textInputFields.length = 0;
//    if (element.data("JSON").staticProperties != null && element.data("JSON").staticProperties != []) {
//        var staticPropertiesArray = element.data("JSON").staticProperties;
//
//        var textInputCount = 0;
//        var radioInputCount = 0;
//        var selectInputCount = 0;
//        var checkboxInputCount = 0;
//
//        for (var i = 0; i < staticPropertiesArray.length; i++) {
//            switch (staticPropertiesArray[i].input.properties.elementType) {
//                case "TEXT_INPUT":
//					var textInput = {};
//					if (staticPropertiesArray[i].input.properties.datatype != undefined)
//					{
//						textInput.fieldName = "textinput" +i;
//						textInput.propertyName = staticPropertiesArray[i].input.properties.datatype;
//						textInputFields.push(textInput);
//					}
//                    string += getTextInputForm(staticPropertiesArray[i].description, staticPropertiesArray[i].name, textInputCount, staticPropertiesArray[i].input.properties.value);
//                    textInputCount++;
//                    continue;
//                case "RADIO_INPUT":
//                    string += getRadioInputForm(staticPropertiesArray[i].description, staticPropertiesArray[i].input.properties.options, radioInputCount);
//                    radioInputCount++;
//                    continue;
//                case "CHECKBOX":
//                    string += getCheckboxInputForm(staticPropertiesArray[i].description, staticPropertiesArray[i].input.properties.options, i);
//                    checkboxInputCount++;
//                    continue;
//                case "SELECT_INPUT":
//                    string += getSelectInputForm(staticPropertiesArray[i].description, staticPropertiesArray[i].input.properties.options, selectInputCount);
//                    selectInputCount++;
//                    continue;
//            }
//        }
//    }
//
//    return string;
//}

//------------------------------------------------------------------------------------------------
//Recommendations
//------------------------------------------------------------------------------------------------



//function isConnected(element) {
//
//    if (jsPlumb.getConnections({source: element}).length < 1 && jsPlumb.getConnections({target: element}).length < 1) {
//        return false;
//    }
//    return true;
//}
//
//function isFullyConnected(element) {
//    return $(element).data("JSON").inputNodes == null || jsPlumb.getConnections({target: $(element)}).length == $(element).data("JSON").inputNodes;
//}
//
//function addAutoComplete(input, datatype) {
//	 console.log(input);
//	    $("#" +input).autocomplete({
//	    source: function(request, response) {
//			$.ajax({
//            url: standardUrl +'autocomplete?propertyName=' +encodeURIComponent(datatype),
//            dataType: "json",
//            data: "term=" + request.term,
//            success: function (data) {
//				var suggestion = new Array();
//				$(data.result).each(function(index, value) {
//					var item = {};
//					item.label = value.label;
//					item.value = value.value;
//					suggestion.push(item);
//				});
//                response(suggestion);
//            }});
//		}
//	});
//}
