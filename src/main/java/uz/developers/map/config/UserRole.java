package uz.developers.map.config;
import com.google.common.collect.Sets;

import java.util.Set;

import static uz.developers.map.config.UserPermission.*;

public enum UserRole {


    USER(Sets.newHashSet(ADDRESS_READ_ALL,ADDRESS_READ_ONE,
            CONTINENT_READ_ALL,CONTINENT_READ_ONE,
            COUNTRY_READ_ALL,COUNTRY_READ_ONE,
            DISTRICT_READ_ALL,DISTRICT_READ_ONE,
            REGION_READ_ALL,REGION_READ_ONE)),

    ADMIN(Sets.newHashSet(ADDRESS_READ_ALL,ADDRESS_READ_ONE,ADDRESS_ADD,ADDRESS_EDIT,
            CONTINENT_READ_ALL,CONTINENT_READ_ONE,CONTINENT_ADD,CONTINENT_EDIT,
            COUNTRY_READ_ALL,COUNTRY_READ_ONE,COUNTRY_ADD,COUNTRY_EDIT,
            DISTRICT_READ_ALL,DISTRICT_READ_ONE,DISTRICT_ADD,DISTRICT_EDIT,
            REGION_READ_ALL,REGION_READ_ONE,REGION_ADD,REGION_EDIT)),

    SUPER_ADMIN(Sets.newHashSet(ADDRESS_READ_ALL,ADDRESS_READ_ONE,ADDRESS_ADD,ADDRESS_EDIT,ADDRESS_DELETE,
            CONTINENT_READ_ALL,CONTINENT_READ_ONE,CONTINENT_ADD,CONTINENT_EDIT,CONTINENT_DELETE,
            COUNTRY_READ_ALL,COUNTRY_READ_ONE,COUNTRY_ADD,COUNTRY_EDIT,COUNTRY_DELETE,
            DISTRICT_READ_ALL,DISTRICT_READ_ONE,DISTRICT_ADD,DISTRICT_EDIT,DISTRICT_DELETE,
            REGION_READ_ALL,REGION_READ_ONE,REGION_ADD,REGION_EDIT,REGION_DELETE));


    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
