import React, { useState } from 'react';
import TestPlaceInput from './TestPlaceInput';
import TestMap from './TestMap';

export default function Map() {
  const defaultProps = {
    center: {
      lat: 37.257175543705614,
      lng: -121.78659396991603,
    },
    zoom: 11,
  };
  const [location, setLocation] = useState(defaultProps);

  function handleSetLocation(latLng) {
    setLocation({ ...location, center: { lat: latLng.lat, lng: latLng.lng } });
  }

  return (
    <>
      <h1>Search places on map</h1>
      <div style={{ marginTop: 15 }}>
        <TestPlaceInput setLocation={handleSetLocation} />
        <TestMap location={location} />
      </div>
    </>
  );
}
