<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<nav id="editor-version-panel" class="sb-slidebar sb-right sb-style-overlay">
	<h3><s:message code="~eu.dariah.de.colreg.titles.version_history" /></h3>
	<ul>
		<c:forEach items="${versions}" var="version">
			<li class="${version.id==selectedVersionId ? 'version-selected ' : ''}${version.deleted ? 'version-deleted ' : 'version-published'}">
				<c:choose>
					<c:when test="${version.id==selectedVersionId}">
						<joda:format value="${version.versionTimestamp}" style="LM" />
						<c:if test="${version.succeedingVersionId==null}">(<s:message code="~eu.dariah.de.colreg.common.labels.latest" />)</c:if><br />
						<span class="version-action">
							<c:choose>
								<c:when test="${version.deleted}">
									<s:message code="~eu.dariah.de.colreg.common.labels.deleted" />
								</c:when>
								<c:otherwise>
									<s:message code="~eu.dariah.de.colreg.common.labels.published" />
								</c:otherwise>
							</c:choose>
						</span><br />
						${version.versionCreator}
					</c:when>
					<c:otherwise>
						<a href="<s:url value="/agents/${version.succeedingVersionId==null ? version.entityId : version.id}" />">
							<joda:format value="${version.versionTimestamp}" style="LM" />
							<c:if test="${version.succeedingVersionId==null}">(<s:message code="~eu.dariah.de.colreg.common.labels.latest" />)</c:if><br />
							<span class="version-action">
								<c:choose>
									<c:when test="${version.deleted}">
										<s:message code="~eu.dariah.de.colreg.common.labels.deleted" />
									</c:when>
									<c:otherwise>
										<s:message code="~eu.dariah.de.colreg.common.labels.published" />
									</c:otherwise>
								</c:choose>
							</span><br />
							${version.versionCreator}
						</a>
					</c:otherwise>
				</c:choose>
			</li>
		</c:forEach>
	</ul>
</nav>