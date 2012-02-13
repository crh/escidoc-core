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
 * Copyright 2006-2008 Fachinformationszentrum Karlsruhe Gesellschaft
 * fuer wissenschaftlich-technische Information mbH and Max-Planck-
 * Gesellschaft zur Foerderung der Wissenschaft e.V.  
 * All rights reserved.  Use is subject to license terms.
 */
package de.escidoc.core.aa.business.stax.handler;

import de.escidoc.core.aa.business.persistence.RoleGrant;
import de.escidoc.core.common.util.xml.stax.events.StartElement;
import de.escidoc.core.common.util.xml.stax.handler.DefaultHandler;

/**
 * Stax handler for grants.
 *
 * @author Torsten Tetteroo
 */
public class GrantStaxHandler extends DefaultHandler {

    private final RoleGrant grant;

    /**
     * The constructor.
     *
     * @param grant The grant.
     */
    public GrantStaxHandler(final RoleGrant grant) {

        this.grant = grant;
    }

    /**
     * See Interface for functional description.
     *
     * @see DefaultHandler #characters(java.lang.String, de.escidoc.core.common.util.xml.stax.events.Star tElement)
     */
    @Override
    public String characters(final String s, final StartElement element) {

        if (isNotReady() && "grant-remark".equals(element.getLocalName())) {
            grant.setGrantRemark(s);
            setReady();
        }

        return s;
    }

}