package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Arrays;

@Class(creator = "AuthorizationCreator")
public class Authorization implements SafeParcelable {
    public static final AuthorizationCreator CREATOR;
    private static final int VERSION = 1;
    @Field(id = 4)
    public final byte[] mData;
    @Field(id = 3)
    public final String mPermitAccessId;
    @Field(id = 2)
    public final String mPermitId;
    @VersionField(id = 1)
    final int mVersion;

    static {
        CREATOR = new AuthorizationCreator();
    }

    public Authorization(String permitId, String permitAccessId, byte[] data) {
        this(VERSION, permitId, permitAccessId, data);
    }

    @Constructor
    Authorization(@Param(id = 1) int version, @Param(id = 2) String permitId, @Param(id = 3) String permitAccessId, @Param(id = 4) byte[] data) {
        this.mVersion = version;
        this.mPermitId = Preconditions.checkNotEmpty(permitId);
        this.mPermitAccessId = Preconditions.checkNotEmpty(permitAccessId);
        this.mData = (byte[]) Preconditions.checkNotNull(data);
    }

    public String getPermitId() {
        return this.mPermitId;
    }

    public String getPermitAccessId() {
        return this.mPermitAccessId;
    }

    public byte[] getData() {
        return this.mData;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Authorization)) {
            return false;
        }
        Authorization authorization = (Authorization) obj;
        if (!(TextUtils.equals(this.mPermitId, authorization.mPermitId) && TextUtils.equals(this.mPermitAccessId, authorization.mPermitAccessId) && Arrays.equals(this.mData, authorization.mData))) {
            z = false;
        }
        return z;
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (31 * ((31 * (this.mPermitId.hashCode() + 527)) + this.mPermitAccessId.hashCode())) + Arrays.hashCode(this.mData);
    }

    public void writeToParcel(Parcel dest, int flags) {
        AuthorizationCreator.writeToParcel(this, dest, flags);
    }
}
