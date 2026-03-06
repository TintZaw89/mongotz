//import React from 'react';
const ErrorFallback = ({ error }) => {

  function refreshPage() {
  window.location.reload();
}

  return (
    <div style={{ padding: '20px' }}>
      <h2>Oops! An error occurred.</h2>
      <p>We're sorry, something unexpected happened. You can try returning to the homepage.</p>
      {/* Optional: display error details in development */}
      {process.env.NODE_ENV === 'development' && (
        <details style={{ whiteSpace: 'pre-wrap', color: 'red' }}>
          {error && error.toString()}
        </details>
      )}
      <button onClick={refreshPage}>Go to About Page</button>
    </div>
  );
};

export default ErrorFallback;
