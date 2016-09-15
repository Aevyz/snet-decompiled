package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ProfileOwnerStatsImpl;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;
import java.util.HashSet;
import java.util.Set;

public class ProfileOwnerStatsImplCreator implements Creator<ProfileOwnerStatsImpl> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ProfileOwnerStatsImpl createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        Set<Integer> _local_safe_0a1b_mIndicatorSet = new HashSet();
        int _local_safe_0a1b_mVersionCode = 0;
        long _local_safe_0a1b_mIncomingAnyCircleCount = 0;
        long _local_safe_0a1b_mViewCount = 0;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_mVersionCode = SafeParcelReader.readInt(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(1));
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_mIncomingAnyCircleCount = SafeParcelReader.readLong(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(2));
                    break;
                case Type.CUSTOM /*3*/:
                    _local_safe_0a1b_mViewCount = SafeParcelReader.readLong(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(3));
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new ProfileOwnerStatsImpl(_local_safe_0a1b_mIndicatorSet, _local_safe_0a1b_mVersionCode, _local_safe_0a1b_mIncomingAnyCircleCount, _local_safe_0a1b_mViewCount);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public ProfileOwnerStatsImpl[] newArray(int size) {
        return new ProfileOwnerStatsImpl[size];
    }

    static void writeToParcel(ProfileOwnerStatsImpl obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> __setFields = obj.mIndicatorSet;
        if (__setFields.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, obj.mVersionCode);
        }
        if (__setFields.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeLong(parcel, 2, obj.mIncomingAnyCircleCount);
        }
        if (__setFields.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeLong(parcel, 3, obj.mViewCount);
        }
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}
