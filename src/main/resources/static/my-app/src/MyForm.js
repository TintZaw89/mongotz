// MyForm.js
import React, { useState } from 'react';

function MyForm({ onSearch }) {
  const [inputValue, setInputValue] = useState('');

  const handleChange = (event) => {
    setInputValue(event.target.value);
  };

  const handleClick = () => {
    onSearch(inputValue); // Pass the input value to the parent or a handler
  };

  return (
    <div>
      <input type="text" value={inputValue} onChange={handleChange} />
      <button onClick={handleClick}>Search</button>
    </div>
  );
}

export default MyForm;