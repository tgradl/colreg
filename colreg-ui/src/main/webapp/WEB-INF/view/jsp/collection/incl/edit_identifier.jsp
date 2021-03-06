<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<s:bind path="providedIdentifier[${currIndex}]">
	<li class="collection-editor-list-item form-item${status.error ? ' has-error' : ' '}">
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
		<sf:errors element="div" cssClass="validation-error col-sm-12" path="providedIdentifier[${currIndex}]" />
	</li>
</s:bind>