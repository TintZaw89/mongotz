import React, { Component } from 'react';
//import { useNavigate } from 'react-router-dom'; // Assuming you use React Router for redirects

class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null };
  }

  static getDerivedStateFromError(error) {
    // Update state so the next render shows the fallback UI.
    return { hasError: true, error: error };
  }

  componentDidCatch(error, errorInfo) {
    // You can also log the error to an error reporting service like Sentry or LogRocket
    console.error("Uncaught error:", error, errorInfo);
    // Example logging: logErrorToMyService(error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      // Render the custom fallback UI or redirect
      if (this.props.fallbackComponent) {
        return <this.props.fallbackComponent error={this.state.error} />;
      }
      // Default fallback
      return <h1>Something went wrong.</h1>;
    }

    return this.props.children;
  }
}

export default ErrorBoundary;
