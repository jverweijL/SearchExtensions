package com.liferay.demo.search;

import com.liferay.asset.util.AssetHelper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.search.spi.model.query.contributor.QueryPreFilterContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author jverweij
 */
@Component(immediate = true, service = QueryPreFilterContributor.class)
public class PageOnlyQueryPreFilterContributor implements QueryPreFilterContributor {

    @Override
    public void contribute(BooleanFilter fullQueryBooleanFilter, SearchContext searchContext) {
        _log.debug("I'm the PageOnlyQueryPreFilterContributor");
        try {
            User user = _userLocalService.getUser(searchContext.getUserId());
            Role role = _roleLocalService.getRole(user.getCompanyId(),"Administrator");

            if (!_roleLocalService.hasUserRole(searchContext.getUserId(), role.getRoleId())) {
                _log.debug("Filter just only pages for regular users");
                fullQueryBooleanFilter.addRequiredTerm(Field.ENTRY_CLASS_NAME, Layout.class.getName());
            }
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
            PageOnlyQueryPreFilterContributor.class);

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private RoleLocalService _roleLocalService;
}