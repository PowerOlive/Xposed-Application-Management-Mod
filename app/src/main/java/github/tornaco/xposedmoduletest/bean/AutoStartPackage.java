package github.tornaco.xposedmoduletest.bean;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "AUTO_START_PACKAGE".
 */
public class AutoStartPackage {

    private Integer id;
    private String pkgName;
    private String appName;
    private Boolean allow;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public AutoStartPackage() {
    }

    public AutoStartPackage(Integer id) {
        this.id = id;
    }

    public AutoStartPackage(Integer id, String pkgName, String appName, Boolean allow) {
        this.id = id;
        this.pkgName = pkgName;
        this.appName = appName;
        this.allow = allow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Boolean getAllow() {
        return allow;
    }

    public void setAllow(Boolean allow) {
        this.allow = allow;
    }

    // KEEP METHODS - put your custom methods here

    @Override
    public String toString() {
        return "AutoStartPackage{" +
                "id=" + id +
                ", pkgName='" + pkgName + '\'' +
                ", appName='" + appName + '\'' +
                ", allow=" + allow +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoStartPackage that = (AutoStartPackage) o;

        return pkgName.equals(that.pkgName);
    }

    @Override
    public int hashCode() {
        return pkgName.hashCode();
    }

    // KEEP METHODS END

}
