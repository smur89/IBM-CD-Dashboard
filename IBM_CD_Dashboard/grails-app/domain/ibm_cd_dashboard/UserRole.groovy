package ibm_cd_dashboard

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole implements Serializable {

    private static final long serialVersionUID = 1

    User secUser
    Role secRole

    boolean equals(other) {
        if (!(other instanceof UserRole)) {
            return false
        }

        other.secUser?.id == secUser?.id &&
                other.secRole?.id == secRole?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (secUser) builder.append(secUser.id)
        if (secRole) builder.append(secRole.id)
        builder.toHashCode()
    }

    static UserRole get(long secUserId, long secRoleId) {
        UserRole.where {
            secUser == User.load(secUserId) &&
                    secRole == Role.load(secRoleId)
        }.get()
    }

    static UserRole create(User secUser, Role secRole, boolean flush = false) {
        new UserRole(secUser: secUser, secRole: secRole).save(flush: flush, insert: true)
    }

    static boolean remove(User u, Role r, boolean flush = false) {

        int rowCount = UserRole.where {
            secUser == User.load(u.id) &&
                    secRole == Role.load(r.id)
        }.deleteAll()

        rowCount > 0
    }

    static void removeAll(User u) {
        UserRole.where {
            secUser == User.load(u.id)
        }.deleteAll()
    }

    static void removeAll(Role r) {
        UserRole.where {
            secRole == Role.load(r.id)
        }.deleteAll()
    }

    static mapping = {
        id composite: ['secRole', 'secUser']
        version false
    }
}
