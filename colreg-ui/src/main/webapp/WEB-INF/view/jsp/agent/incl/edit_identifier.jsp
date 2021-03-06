<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li class="collection-editor-list-item">
	<div class="collection-editor-list-input col-sm-7">
		<span class="attribute-name-helper">providedIdentifier{}</span>
		<span style="display: inline-block; width: 100%;">
			<input type="text" class="form-control" id="providedIdentifier${currIndex}" name="providedIdentifier[${currIndex}]" 
				value="<c:if test="${currIdentifier!=null}">${currIdentifier}</c:if>">
		</span>
	</div>
	<div class="collection-editor-list-item-buttons">
		<button onclick="editor.lists['identifierList'].pushEntryUp(this); return false;" class="btn btn-xs btn-link btn-push-up"><span class="glyphicon glyphicon glyphicon-arrow-up" aria-hidden="true"></span></button>
		<button onclick="editor.lists['identifierList'].pushEntryDown(this); return false;" class="btn btn-xs btn-link btn-push-down"><span class="glyphicon glyphicon glyphicon-arrow-down" aria-hidden="true"></span></button>
		<button onclick="editor.lists['identifierList'].removeEntry(this); return false;" class="btn btn-xs btn-link"><span class="glyphicon glyphicon-trash glyphicon-color-danger" aria-hidden="true"></span></button>
	</div>
</li>