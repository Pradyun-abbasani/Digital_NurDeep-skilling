import React, { useState } from "react";

function UserGreeting() {
  return <h1>Welcome back</h1>;
}

function GuestGreeting() {
  return <h1>Please sign up.</h1>;
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function LoginButton(props) {
  return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
  return <button onClick={props.onClick}>Logout</button>;
}

function UserPage() {
  return (
    <div>
      <p>You are now logged in.</p>
    </div>
  );
}

function GuestPage() {
  return (
    <div>
      <p>Please log in to continue.</p>
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => setIsLoggedIn(true);
  const handleLogoutClick = () => setIsLoggedIn(false);

  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div style={{ padding: "20px" }}>
      <Greeting isLoggedIn={isLoggedIn} />
      {button}
      <hr />
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
