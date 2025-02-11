package org.cbs.data;

import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.nio.file.Path;

import org.apache.logging.log4j.Logger;
import org.cbs.data.admin.props.*;
import org.cbs.data.admin.props.ClientsPageProps;
import org.cbs.data.admin.props.CreateOwnerPageProps;
import org.cbs.data.admin.props.ClientDetailsProps;
import org.cbs.data.admin.props.HomepageProps;
import org.cbs.data.admin.props.LoginProps;
import org.cbs.data.admin.props.SonnyUsersPageProps;
import org.cbs.data.admin.props.UserAccessGroupListingProps;
import org.cbs.utils.JsonUtil;

public final class DataReader {
    private static final Logger LOGGER = getLogger ();

    public static LoginProps loadAdminLoginProps () {
        LoginProps loginProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("PROPERTIES_PROPS_PATH")).orElse (
            ofNullable (getProperty ("login.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "login-props.json")
            .toString ();
        loginProps = JsonUtil.fromFile (configPath, LoginProps.class);
        return LOGGER.traceExit (loginProps);
    }

    public static HomepageProps loadAdminHomepageProps () {
        HomepageProps homepageProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "homepage-props.json")
            .toString ();
        homepageProps = JsonUtil.fromFile (configPath, HomepageProps.class);
        return LOGGER.traceExit (homepageProps);
    }

    public static SonnyUsersPageProps loadAdminSonnyUserspageProps () {
        SonnyUsersPageProps sonnyuserspageProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "sonnyuserspage-props.json")
            .toString ();
        sonnyuserspageProps = JsonUtil.fromFile (configPath, SonnyUsersPageProps.class);
        return LOGGER.traceExit (sonnyuserspageProps);
    }

    public static ClientDetailsProps loadClientDetailsProps () {
        ClientDetailsProps clientDetailsProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "clientdetails-props.json")
            .toString ();
        clientDetailsProps = JsonUtil.fromFile (configPath, ClientDetailsProps.class);
        return LOGGER.traceExit (clientDetailsProps);
    }

    public static UserAccessGroupListingProps loadAdminUserAccessGroupListingProps () {
        UserAccessGroupListingProps userAccessGroupListingProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "userAccessGroupListing-props.json")
            .toString ();
        userAccessGroupListingProps = JsonUtil.fromFile (configPath, UserAccessGroupListingProps.class);
        return LOGGER.traceExit (userAccessGroupListingProps);
    }

    public static OrganizationProps loadAdminOrganizationProps () {
        OrganizationProps organizationProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "organization-props.json")
            .toString ();
        organizationProps = JsonUtil.fromFile (configPath, OrganizationProps.class);
        return LOGGER.traceExit (organizationProps);
    }

    public static ClientsPageProps loadClientsPageProps () {
        ClientsPageProps clientsPageProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "clients-page-props.json")
            .toString ();
        clientsPageProps = JsonUtil.fromFile (configPath, ClientsPageProps.class);
        return LOGGER.traceExit (clientsPageProps);
    }

    public static CreateOwnerPageProps loadCreateOwnerPageProps () {
        CreateOwnerPageProps createOwnerPageProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
            .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
            ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "createOwner-page-props.json")
            .toString ();
        createOwnerPageProps = JsonUtil.fromFile (configPath, CreateOwnerPageProps.class);
        return LOGGER.traceExit (createOwnerPageProps);
    }
    public static CreateUserAccessGroupProps loadAdminCreateUserAccessGroupProps () {
        CreateUserAccessGroupProps createUserAccessGroupProps = null;
        LOGGER.traceEntry();
        final var defaultPath = Path.of(getProperty("user.dir"), "src/test/resources/data.json/admin/props/")
                .toString();
        final var configDirectory = ofNullable(getenv("ADMIN_PROPS_PATH")).orElse(
                ofNullable(getProperty("admin.props.path")).orElse(defaultPath));
        final var configPath = Path.of(configDirectory, "createUserAccessGroup-props.json")
                .toString();
        createUserAccessGroupProps = JsonUtil.fromFile(configPath, CreateUserAccessGroupProps.class);
        return LOGGER.traceExit(createUserAccessGroupProps);
    }

    public static EditUserAccessGroupProps loadAdminEditUserAccessGroupProps () {
        EditUserAccessGroupProps editUserAccessGroupProps = null;
        LOGGER.traceEntry ();
        final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources/data.json/admin/props/")
                .toString ();
        final var configDirectory = ofNullable (getenv ("ADMIN_PROPS_PATH")).orElse (
                ofNullable (getProperty ("admin.props.path")).orElse (defaultPath));
        final var configPath = Path.of (configDirectory, "editUserAccessGroup-props.json")
                .toString ();
        editUserAccessGroupProps = JsonUtil.fromFile (configPath, EditUserAccessGroupProps.class);
        return LOGGER.traceExit (editUserAccessGroupProps);
    }

}
