package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PhoneNumbersImpl;
import com.google.wireless.android.play.playlog.proto.UserLocation.LocationSharingEvent;
import com.google.wireless.android.play.playlog.proto.UserLocation.OvenFreshEvent.OvenFreshResult;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumbersImplCreator implements Creator<PhoneNumbersImpl> {
    public static final int CONTENT_DESCRIPTION = 0;

    public PhoneNumbersImpl createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        Set<Integer> _local_safe_0a1b_mIndicatorSet = new HashSet();
        int _local_safe_0a1b_mVersionCode = 0;
        MetadataImpl _local_safe_0a1b_mMetadata = null;
        String _local_safe_0a1b_mCanonicalizedForm = null;
        String _local_safe_0a1b_mFormattedType = null;
        String _local_safe_0a1b_mType = null;
        String _local_safe_0a1b_mValue = null;
        int _local_safe_0a1b_mTimesUsed = 0;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_mVersionCode = SafeParcelReader.readInt(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(1));
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_mMetadata = (MetadataImpl) SafeParcelReader.createParcelable(parcel, header, MetadataImpl.CREATOR);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(2));
                    break;
                case Type.CUSTOM /*3*/:
                    _local_safe_0a1b_mCanonicalizedForm = SafeParcelReader.createString(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(3));
                    break;
                case OvenFreshResult.NO_ACCOUNTS /*4*/:
                    _local_safe_0a1b_mFormattedType = SafeParcelReader.createString(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(4));
                    break;
                case LocationSharingEvent.Type.ADD_NEW_SHARES /*5*/:
                    _local_safe_0a1b_mType = SafeParcelReader.createString(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(5));
                    break;
                case LocationSharingEvent.Type.REMOVE_SHARE /*6*/:
                    _local_safe_0a1b_mValue = SafeParcelReader.createString(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(6));
                    break;
                case LocationSharingEvent.Type.RESET_TIME /*7*/:
                    _local_safe_0a1b_mTimesUsed = SafeParcelReader.readInt(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(7));
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new PhoneNumbersImpl(_local_safe_0a1b_mIndicatorSet, _local_safe_0a1b_mVersionCode, _local_safe_0a1b_mMetadata, _local_safe_0a1b_mCanonicalizedForm, _local_safe_0a1b_mFormattedType, _local_safe_0a1b_mType, _local_safe_0a1b_mValue, _local_safe_0a1b_mTimesUsed);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public PhoneNumbersImpl[] newArray(int size) {
        return new PhoneNumbersImpl[size];
    }

    static void writeToParcel(PhoneNumbersImpl obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> __setFields = obj.mIndicatorSet;
        if (__setFields.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, obj.mVersionCode);
        }
        if (__setFields.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeParcelable(parcel, 2, obj.mMetadata, flags, true);
        }
        if (__setFields.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeString(parcel, 3, obj.mCanonicalizedForm, true);
        }
        if (__setFields.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeString(parcel, 4, obj.mFormattedType, true);
        }
        if (__setFields.contains(Integer.valueOf(5))) {
            SafeParcelWriter.writeString(parcel, 5, obj.mType, true);
        }
        if (__setFields.contains(Integer.valueOf(6))) {
            SafeParcelWriter.writeString(parcel, 6, obj.mValue, true);
        }
        if (__setFields.contains(Integer.valueOf(7))) {
            SafeParcelWriter.writeInt(parcel, 7, obj.mTimesUsed);
        }
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}
