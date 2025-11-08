import React from 'react';

const Dropdown = ({ onSelectChange }) => {
  const handleChange = (event) => {
    onSelectChange(event.target.value);
  };

  return (
    <select onChange={handleChange}>
      <option value="">--Please choose an option--</option>
      <option value="option1">Title</option>
      <option value="option2">Actor</option>
      <option value="option3">Year</option>
      <option value="option5">Director</option>
    </select>
  );
};

export default Dropdown;