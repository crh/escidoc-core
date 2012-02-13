/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at license/ESCIDOC.LICENSE
 * or http://www.escidoc.de/license.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at license/ESCIDOC.LICENSE.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */

/*
 * Copyright 2006-2011 Fachinformationszentrum Karlsruhe Gesellschaft
 * fuer wissenschaftlich-technische Information mbH and Max-Planck-
 * Gesellschaft zur Foerderung der Wissenschaft e.V.  
 * All rights reserved.  Use is subject to license terms.
 */
package de.escidoc.core.sm.internal;

import org.escidoc.core.domain.service.ServiceUtility;
import org.escidoc.core.domain.sm.ReportDefinitionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.escidoc.core.common.exceptions.application.invalid.InvalidSqlException;
import de.escidoc.core.common.exceptions.application.invalid.XmlCorruptedException;
import de.escidoc.core.common.exceptions.application.invalid.XmlSchemaValidationException;
import de.escidoc.core.common.exceptions.application.missing.MissingMethodParameterException;
import de.escidoc.core.common.exceptions.application.notfound.ReportDefinitionNotFoundException;
import de.escidoc.core.common.exceptions.application.notfound.ScopeNotFoundException;
import de.escidoc.core.common.exceptions.application.security.AuthenticationException;
import de.escidoc.core.common.exceptions.application.security.AuthorizationException;
import de.escidoc.core.common.exceptions.application.violated.ScopeContextViolationException;
import de.escidoc.core.common.exceptions.system.SystemException;
import de.escidoc.core.sm.ReportDefinitionRestService;
import de.escidoc.core.sm.service.interfaces.ReportDefinitionHandlerInterface;

/**
 * @author Michael Hoppe
 *
 */
public class ReportDefinitionRestServiceImpl implements ReportDefinitionRestService {

    @Autowired
    @Qualifier("service.ReportDefinitionHandler")
    private ReportDefinitionHandlerInterface reportDefinitionHandler;

    /**
     * 
     */
    public ReportDefinitionRestServiceImpl() {
    }

    /* (non-Javadoc)
     * @see de.escidoc.core.sm.ReportDefinitionRestService#create(org.escidoc.core.domain.sm.ReportDefinitionTO)
     */
    @Override
    public ReportDefinitionTO create(final ReportDefinitionTO reportDefinitionTO) throws AuthenticationException,
        AuthorizationException, XmlSchemaValidationException, XmlCorruptedException, MissingMethodParameterException,
        InvalidSqlException, ScopeNotFoundException, ScopeContextViolationException, SystemException {
        return ServiceUtility.fromXML(ReportDefinitionTO.class, this.reportDefinitionHandler.create(ServiceUtility.toXML(reportDefinitionTO)));
    }

    /* (non-Javadoc)
     * @see de.escidoc.core.sm.ReportDefinitionRestService#delete(java.lang.String)
     */
    @Override
    public void delete(final String id) throws AuthenticationException, AuthorizationException,
        ReportDefinitionNotFoundException, MissingMethodParameterException, SystemException {
        this.reportDefinitionHandler.delete(id);
    }

    /* (non-Javadoc)
     * @see de.escidoc.core.sm.ReportDefinitionRestService#retrieve(java.lang.String)
     */
    @Override
    public ReportDefinitionTO retrieve(final String id) throws AuthenticationException, AuthorizationException,
        ReportDefinitionNotFoundException, MissingMethodParameterException, SystemException {
        return ServiceUtility.fromXML(ReportDefinitionTO.class, this.reportDefinitionHandler.retrieve(id));
    }

    /* (non-Javadoc)
     * @see de.escidoc.core.sm.ReportDefinitionRestService#update(java.lang.String, org.escidoc.core.domain.sm.ReportDefinitionTO)
     */
    @Override
    public ReportDefinitionTO update(final String id, final ReportDefinitionTO reportDefinitionTO) throws AuthenticationException,
        AuthorizationException, ReportDefinitionNotFoundException, MissingMethodParameterException,
        ScopeNotFoundException, InvalidSqlException, ScopeContextViolationException, XmlSchemaValidationException,
        XmlCorruptedException, SystemException {
        return ServiceUtility.fromXML(ReportDefinitionTO.class, this.reportDefinitionHandler.update(id, ServiceUtility.toXML(reportDefinitionTO)));
    }

}
