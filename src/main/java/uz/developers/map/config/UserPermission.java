package uz.developers.map.config;

public enum  UserPermission {

    ADDRESS_READ_ALL("address:readAll"),
    ADDRESS_READ_ONE("address:readOne"),
    ADDRESS_ADD("address:add"),
    ADDRESS_EDIT("address:edit"),
    ADDRESS_DELETE("address:delete"),

    CONTINENT_READ_ALL("continent:readAll"),
    CONTINENT_READ_ONE("continent:readOne"),
    CONTINENT_ADD("continent:add"),
    CONTINENT_EDIT("continent:edit"),
    CONTINENT_DELETE("continent:delete"),

    COUNTRY_READ_ALL("country:readAll"),
    COUNTRY_READ_ONE("country:readOne"),
    COUNTRY_ADD("country:add"),
    COUNTRY_EDIT("country:edit"),
    COUNTRY_DELETE("country:delete"),

    DISTRICT_READ_ALL("district:readAll"),
    DISTRICT_READ_ONE("district:readOne"),
    DISTRICT_ADD("district:add"),
    DISTRICT_EDIT("district:edit"),
    DISTRICT_DELETE("district:delete"),

    REGION_READ_ALL("region:readAll"),
    REGION_READ_ONE("region:readOne"),
    REGION_ADD("region:add"),
    REGION_EDIT("region:edit"),
    REGION_DELETE("region:delete");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
